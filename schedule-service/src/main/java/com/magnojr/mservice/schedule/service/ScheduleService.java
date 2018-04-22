package com.magnojr.mservice.schedule.service;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magnojr.mservice.schedule.model.ReservationIntent;
import com.magnojr.mservice.schedule.model.Schedule;
import com.magnojr.mservice.schedule.queue.RegisterScheduleMessage;
import com.magnojr.mservice.schedule.queue.ScheduleMessageSender;
import com.magnojr.mservice.schedule.repository.ScheduleRepository;

@Service
public class ScheduleService {

	@Autowired
	ScheduleRepository repository;
	
	@Autowired
	ScheduleMessageSender messageSender;
	
	public ReservationIntent checkReservationIntent(Long id, LocalDate start, LocalDate end) {
		ReservationIntent reservationIntent = new ReservationIntent();
		
		List<Schedule> dates = repository.findByDateBetweenAndIdAccommodation(start, end, id);
		reservationIntent.check(start, end, dates);
		reservationIntent.addDatesInformed(dates);

		return reservationIntent;
	}

	public Boolean reserveSchedule(Long id, LocalDate start, LocalDate end, Long reservationId) {
		boolean success = false;
		if(this.checkReservationIntent(id, start, end).isAvailable()){
			List<Schedule> list = repository.findByDateBetweenAndIdAccommodation(start, end, id);
			list.forEach((schedule) -> {
				schedule.reserved();				
			});
			repository.saveAll(list);
			// send schedule confirmation to queue
			messageSender.sendMessage(new RegisterScheduleMessage(reservationId, true));
			success = true;
		}else{
			messageSender.sendMessage(new RegisterScheduleMessage(reservationId, false));
		}
		return success;
	}

}
