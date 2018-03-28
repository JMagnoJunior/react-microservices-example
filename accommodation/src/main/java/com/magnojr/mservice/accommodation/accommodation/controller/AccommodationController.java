package com.magnojr.mservice.accommodation.accommodation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.magnojr.mservice.accommodation.accommodation.model.Accommodation;
import com.magnojr.mservice.accommodation.accommodation.service.AccommodationService;

//@RestController
public class AccommodationController {
	
//	@Autowired
	AccommodationService service;
	
//	@RequestMapping("/accommodations")
	public List<Accommodation> listAccommodations(){
		List<Accommodation> list = service.listAccommodations();
		return list;
	}
	
}
