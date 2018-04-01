package com.magnojr.mservice.schedule.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AvailabilityAndPrice {

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

}
