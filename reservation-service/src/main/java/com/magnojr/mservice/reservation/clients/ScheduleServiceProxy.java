package com.magnojr.mservice.reservation.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.magnojr.mservice.reservation.FeignClientConfiguration;
import com.magnojr.mservice.reservation.bean.ReservationIntent;

@FeignClient(name = "schedule", url = "${schedule.service.uri}", configuration = FeignClientConfiguration.class)
public interface ScheduleServiceProxy {

	@RequestMapping(path = "/reservation-intent/accommodations/{id}/from/{start}/to/{end}", method = RequestMethod.GET)
	public ReservationIntent checkAvailability(@PathVariable(value = "id") Long id,
			@PathVariable(value = "start") String start,
			@PathVariable(value = "end")  String end);
	
	
}
