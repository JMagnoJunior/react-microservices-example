package com.magnojr.mservice.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.magnojr.mservice.reservation.model.Reservation;
import com.magnojr.mservice.reservation.service.ReservationService;

@RestController
public class ReservationController {

	@Autowired
	ReservationService service;
	
	@PostMapping(path="/reserve/accommodation/{accommodationId}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Reservation reserve(@PathVariable(value="accommodationId") Long accommodationId,@RequestBody Reservation reservation){
		return service.reserve(reservation, accommodationId);		
	}
	
	
}
