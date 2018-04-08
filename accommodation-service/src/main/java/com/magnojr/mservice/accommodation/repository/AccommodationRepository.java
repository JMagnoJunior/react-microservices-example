package com.magnojr.mservice.accommodation.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.magnojr.mservice.accommodation.model.Accommodation;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


//@Api(tags = "Accommodation")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost"})
@RepositoryRestResource(collectionResourceRel = "accommodations", path = "accommodations")
public interface AccommodationRepository extends PagingAndSortingRepository<Accommodation, Long> {
	 @ApiOperation("Find some accommodations by name")
	    @ApiImplicitParams({
	        @ApiImplicitParam(name = "name", paramType = "query")
	    })	
	List<Accommodation> findByNameContainingIgnoreCase(@Param("name") String name);
}
