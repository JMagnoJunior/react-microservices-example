package com.magnojr.mservice.accommodation.accommodation.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magnojr.mservice.accommodation.accommodation.model.AvailabilityAndPrice;
import com.magnojr.mservice.accommodation.accommodation.model.DateAvailability;
import com.magnojr.mservice.accommodation.accommodation.repository.AccommodationScheduleRepository;

@Service
public class AccommodationService {

	@Autowired
	AccommodationScheduleRepository repository;
	
	public AvailabilityAndPrice checkAvailabilityAndPrice(Long id, Date start, Date end) {
		AvailabilityAndPrice result = new AvailabilityAndPrice();
		
		List<DateAvailability> dates = repository.findByDateBetweenAndAccommodationId(start, end, id);
		
		List<DateAvailability> unavailable = dates.stream().filter((d) -> !d.getAvaliable() ).collect(Collectors.toList());
		if(unavailable.isEmpty()){
			result.setAvailible(true);
		}else{
			result.setAvailible(false);
		}
		Optional<BigDecimal> price = dates.stream().map(DateAvailability::getPrice).reduce( (p1,p2) -> p1.add(p2) );
		result.setPrice(price.get());
		return result;
	}

}
