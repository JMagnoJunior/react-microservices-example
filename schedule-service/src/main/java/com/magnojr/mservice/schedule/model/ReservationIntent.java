package com.magnojr.mservice.schedule.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.magnojr.mservice.schedule.exception.ScheduleException;

public class ReservationIntent {

	private boolean available;
	private BigDecimal price;

	public boolean isAvailable() {
		return available;
	}

	public void setAvailible(boolean availible) {
		this.available = availible;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public void addDatesInformed(List<Schedule> dates) {
		List<Schedule> unavailable = dates.stream().filter((d) -> !d.getAvaliable() ).collect(Collectors.toList());
		if(unavailable.isEmpty()){
			this.setAvailible(true);
		}else{
			this.setAvailible(false);
		}
		Optional<BigDecimal> price = dates.stream().map(Schedule::getPrice).reduce( (p1,p2) -> p1.add(p2) );
		this.setPrice(price.get());		
	}

	public void check(LocalDate start, LocalDate end, List<Schedule> schedules) throws ScheduleException {
		
		List<LocalDate> dates = schedules.stream().map((d) -> ( d.getDate() ) ).collect(Collectors.toList());
		
		if (!dates.contains(start)){
			throw new ScheduleException("invalid start date");
		}
		if(!dates.contains(end)){
			throw new ScheduleException("invalid end date");
		}		
		
	}

}
