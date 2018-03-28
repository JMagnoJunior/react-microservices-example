package com.magnojr.mservice.accommodation.accommodation.repository;

import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.magnojr.mservice.accommodation.accommodation.model.AccommodationSchedule;

@RepositoryRestResource(collectionResourceRel = "schedule", path = "schedule")
public interface AccommodationScheduleRepository extends Repository<AccommodationSchedule, Long> {
	AccommodationSchedule findById(Long id);
}
