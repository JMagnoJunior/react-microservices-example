package com.magnojr.mservice.accommodation.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magnojr.mservice.accommodation.model.AvailabilityAndPrice;
import com.magnojr.mservice.accommodation.model.DateAvailability;
import com.magnojr.mservice.accommodation.repository.AccommodationScheduleRepository;

@Service
public class AccommodationService {

	@Autowired
	AccommodationScheduleRepository repository;
	
	public AvailabilityAndPrice checkAvailabilityAndPrice(Long id, Date start, Date end) {
		AvailabilityAndPrice result = new AvailabilityAndPrice();
		
		List<DateAvailability> dates = repository.findByDateBetweenAndAccommodationId(start, end, id);
		
		result.addDatesInformed(dates);

		return result;
	}

}
