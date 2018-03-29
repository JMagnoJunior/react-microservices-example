package com.magnojr.mservice.accommodation.accommodation.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.magnojr.mservice.accommodation.accommodation.model.Accommodation;

@RepositoryRestResource(collectionResourceRel = "accommodation", path = "accommodations")
public interface AccommodationRepository extends PagingAndSortingRepository<Accommodation, Long> {
		
	List<Accommodation> findByNameContainingIgnoreCase(@Param("name") String name);
}
