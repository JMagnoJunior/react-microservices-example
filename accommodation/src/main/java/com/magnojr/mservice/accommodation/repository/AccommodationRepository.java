package com.magnojr.mservice.accommodation.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.magnojr.mservice.accommodation.model.Accommodation;

@CrossOrigin(origins = "http://localhost:3000")
@RepositoryRestResource(collectionResourceRel = "accommodation", path = "accommodations")
public interface AccommodationRepository extends PagingAndSortingRepository<Accommodation, Long> {
		
	List<Accommodation> findByNameContainingIgnoreCase(@Param("name") String name);
}