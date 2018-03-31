package com.magnojr.mservice.reservation.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.magnojr.mservice.reservation.FeignClientConfiguration;
import com.magnojr.mservice.reservation.bean.AvailabilityAndPrice;

@FeignClient(name = "accommodation", url = "${accommodation-service-uri}", configuration = FeignClientConfiguration.class)
public interface AccommodationServiceProxy {

	@RequestMapping(path = "/accommodations/{id}/checkavailability/from/{start}/to/{end}", method = RequestMethod.GET)
	public AvailabilityAndPrice checkAvailability(@PathVariable(value = "id") Long id,
			@PathVariable(value = "start") String start,
			@PathVariable(value = "end")  String end);
}
