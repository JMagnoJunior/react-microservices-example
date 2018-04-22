package com.magnojr.mservice.schedule.controller;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.magnojr.mservice.schedule.model.ReservationIntent;
import com.magnojr.mservice.schedule.service.ScheduleService;


@RestController
public class ReservationIntentController {

	@Autowired
	ScheduleService service;

	@RequestMapping(path = "/reservation-intent/accommodations/{id}/from/{start}/to/{end}", method = RequestMethod.GET)
	public ReservationIntent checkReservationIntent(@PathVariable(value = "id")  Long id, @PathVariable(value = "start") @DateTimeFormat(pattern = "yyyy-MM-dd")  LocalDate start,
			@PathVariable(value = "end") @DateTimeFormat(pattern = "yyyy-MM-dd")  LocalDate end) {
		
		return service.checkReservationIntent(id, start, end);
	}

}
