package com.magnojr.mservice.accommodation.processor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.stereotype.Component;

import com.magnojr.mservice.accommodation.model.Accommodation;

@Component
public class AccommodationResourceProcessor implements ResourceProcessor<Resource<Accommodation>> {

	@Value("${schedule-resource-url}")
	private String scheduleResourceUrl;

	private final String SEARCH_ACCOMMODATION_PATH = "search/findByIdAccommodation?id_accommodation=";

	@Override
	public Resource<Accommodation> process(Resource<Accommodation> scheduleResource) {

		scheduleResource.add(new Link(
				scheduleResourceUrl + SEARCH_ACCOMMODATION_PATH + scheduleResource.getContent().getId(), "schedules"));

		return scheduleResource;
	}
}
