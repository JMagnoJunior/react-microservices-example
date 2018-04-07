package com.magnojr.mservice.schedule.service;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magnojr.mservice.schedule.model.AvailabilityAndPrice;
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
	
	public AvailabilityAndPrice checkAvailabilityAndPrice(Long id, Date start, Date end) {
		AvailabilityAndPrice result = new AvailabilityAndPrice();
		
		List<Schedule> dates = repository.findByDateBetweenAndIdAccommodation(start, end, id);
		
		result.addDatesInformed(dates);

		return result;
	}

	public Boolean checkAndRegisterSchedule(Long id, Date start, Date end, Long reservationId) {
		if(this.checkAvailabilityAndPrice(id, start, end).isAvailable()){
			List<Schedule> list = repository.findByDateBetweenAndIdAccommodation(start, end, id);
			list.forEach((schedule) -> {
				schedule.reserved();				
			});
			repository.saveAll(list);
			// send schedule confirmation to queue
			messageSender.sendMessage(new RegisterScheduleMessage(reservationId, true));
			return true;
		}else{
			messageSender.sendMessage(new RegisterScheduleMessage(reservationId, false));
		}
		return  false;
	}

}