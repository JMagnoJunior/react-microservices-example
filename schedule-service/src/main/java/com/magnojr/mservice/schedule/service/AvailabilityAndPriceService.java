package com.magnojr.mservice.schedule.service;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magnojr.mservice.schedule.model.AvailabilityAndPrice;
import com.magnojr.mservice.schedule.model.DateAvailability;
import com.magnojr.mservice.schedule.repository.AccommodationScheduleRepository;

@Service
public class AvailabilityAndPriceService {

	@Autowired
	AccommodationScheduleRepository repository;
	
	public AvailabilityAndPrice checkAvailabilityAndPrice(Long id, Date start, Date end) {
		AvailabilityAndPrice result = new AvailabilityAndPrice();
		
		List<DateAvailability> dates = repository.findByDateBetweenAndAccommodationId(start, end, id);
		
		result.addDatesInformed(dates);

		return result;
	}

}
