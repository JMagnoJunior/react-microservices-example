package com.magnojr.mservice.accommodation.accommodation.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magnojr.mservice.accommodation.accommodation.model.DateAvailability;
import com.magnojr.mservice.accommodation.accommodation.repository.AccommodationScheduleRepository;

@Service
public class AccommodationService {

	@Autowired
	AccommodationScheduleRepository repository;
	
	public boolean checkAvailability(Long id, Date start, Date end) {
		boolean result = false;
		
		List<DateAvailability> dates = repository.findByDateBetweenAndAccommodationId(start, end, id);
		
		List<DateAvailability> unavailable = dates.stream().filter((d) -> !d.getAvaliable() ).collect(Collectors.toList());
		if(unavailable.isEmpty()){
			result = true;
		}else{
			result = false;
		}
		return result;
	}

}
