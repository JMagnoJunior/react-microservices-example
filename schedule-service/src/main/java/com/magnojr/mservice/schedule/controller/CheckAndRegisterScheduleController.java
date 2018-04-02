package com.magnojr.mservice.schedule.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.magnojr.mservice.schedule.model.AvailabilityAndPrice;
import com.magnojr.mservice.schedule.service.ScheduleService;

@RestController
public class CheckAndRegisterScheduleController {

	@Autowired
	ScheduleService service;
	
	@RequestMapping(path = "/checkandregisterschedule/accommodations/{id}/from/{start}/to/{end}", method = RequestMethod.POST)
	public Boolean checkAvailabilityAndPrice(@PathVariable(value = "id")  Long id, @PathVariable(value = "start") @DateTimeFormat(pattern = "yyyy-MM-dd")  Date start,
			@PathVariable(value = "end") @DateTimeFormat(pattern = "yyyy-MM-dd")  Date end) {
		
		return service.checkAndRegisterSchedule(id, start, end);
	}
	
}
