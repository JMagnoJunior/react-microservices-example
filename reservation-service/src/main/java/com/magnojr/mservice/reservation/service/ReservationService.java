package com.magnojr.mservice.reservation.service;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magnojr.mservice.reservation.bean.AvailabilityAndPrice;
import com.magnojr.mservice.reservation.clients.AccommodationServiceProxy;
import com.magnojr.mservice.reservation.model.PeriodReserved;
import com.magnojr.mservice.reservation.model.Reservation;
import com.magnojr.mservice.reservation.repository.ReservationRepository;

@Service
public class ReservationService {

	@Autowired
	private AccommodationServiceProxy accommodationService;

	@Autowired
	private ReservationRepository repository;
	
	public Reservation reserve(Reservation reservation) {
		Reservation result = null;
		PeriodReserved period = reservation.getPeriodReserved();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		AvailabilityAndPrice verification = accommodationService.checkAvailability(reservation.getAccommodation_id(), 
				df.format(period.getBegin()),
				df.format(period.getEnd()) );
		if(verification.isAvailible()){
			reservation.setTotalPrice(verification.getPrice());
			result = repository.save(reservation);
		}else{
			//TODO: Throw exception
		}
		
		return result;
	}
}
