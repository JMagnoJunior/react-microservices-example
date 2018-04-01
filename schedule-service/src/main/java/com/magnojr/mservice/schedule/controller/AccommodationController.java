//package com.magnojr.mservice.schedule.controller;
//
//
//import java.util.Date;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.format.annotation.DateTimeFormat;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//
//@RestController
//public class AccommodationController {
//
//	@Autowired
//	AccommodationService service;
//
//	@RequestMapping(path = "/accommodations/{id}/checkavailability/from/{start}/to/{end}", method = RequestMethod.GET)
//	public AvailabilityAndPrice checkAvailabilityAndPrice(@PathVariable(value = "id")  Long id, @PathVariable(value = "start") @DateTimeFormat(pattern = "yyyy-MM-dd")  Date start,
//			@PathVariable(value = "end") @DateTimeFormat(pattern = "yyyy-MM-dd")  Date end) {
//		
//		return service.checkAvailabilityAndPrice(id, start, end);
//	}
//
//}
