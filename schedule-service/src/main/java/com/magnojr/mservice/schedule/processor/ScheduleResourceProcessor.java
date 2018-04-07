package com.magnojr.mservice.schedule.processor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.stereotype.Component;

import com.magnojr.mservice.schedule.model.Schedule;

@Component
public class ScheduleResourceProcessor implements ResourceProcessor<Resource<Schedule>> {

	@Value("${accommodation.resource.url}")
	private String accommodationResourceUrl;

	@Override
	public Resource<Schedule> process(Resource<Schedule> scheduleResource) {

		// URI location =
		// ServletUriComponentsBuilder.fromHttpUrl("").path("/{id}").buildAndExpand(scheduleResource.getContent().getIdAccommodation());

		scheduleResource.add(new Link(accommodationResourceUrl + scheduleResource.getContent().getIdAccommodation(), "accommodation"));
		
		return scheduleResource;
	}
	

}
