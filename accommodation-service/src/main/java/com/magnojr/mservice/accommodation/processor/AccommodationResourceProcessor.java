package com.magnojr.mservice.accommodation.processor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.stereotype.Component;

import com.magnojr.mservice.accommodation.model.Accommodation;

/**
 * This processor will added in the accommodation resource a new link pointing
 * for its schedule resource.
 * 
 * @author magnojr
 *
 */
@Component
public class AccommodationResourceProcessor implements ResourceProcessor<Resource<Accommodation>> {

	@Value("${schedule.resource.url}")
	private String scheduleResourceUrl;

	@Value("${reservation.resource.url}")
	private String reservationResourceUrl;
	
	private final String SEARCH_ACCOMMODATION_PATH = "search/findByIdAccommodation?id_accommodation=";

	private final String RESERVE_ACCOMMODATION_PATH =  "accommodation/";
	
	@Override
	public Resource<Accommodation> process(Resource<Accommodation> customAccommodationResource) {

		customAccommodationResource.add(new Link(
				scheduleResourceUrl + SEARCH_ACCOMMODATION_PATH + customAccommodationResource.getContent().getId(), "schedules"));

		customAccommodationResource.add(new Link(
				reservationResourceUrl + RESERVE_ACCOMMODATION_PATH + customAccommodationResource.getContent().getId(), "reserve"));
		return customAccommodationResource;
	}
}
