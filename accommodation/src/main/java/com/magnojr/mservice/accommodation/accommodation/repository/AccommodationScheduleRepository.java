package com.magnojr.mservice.accommodation.accommodation.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.format.annotation.DateTimeFormat;

import com.magnojr.mservice.accommodation.accommodation.model.DateAvailability;



@RepositoryRestResource(collectionResourceRel = "schedule", path = "schedule")
public interface AccommodationScheduleRepository extends PagingAndSortingRepository<DateAvailability, Long>, CrudRepository<DateAvailability, Long> {
	
	
	List<DateAvailability> findByAccommodationId(@Param("id")  Long id);
	List<DateAvailability> findByDateAndAccommodationId(@Param("date")  @DateTimeFormat(pattern="yyyy-MM-dd") Date start,@Param("accommodation_id") Long id);
	List<DateAvailability> findByDateBetweenAndAccommodationId(@Param("start")  @DateTimeFormat(pattern="yyyy-MM-dd") Date start, @Param("end")  @DateTimeFormat(pattern="yyyy-MM-dd") Date end, @Param("accommodation_id") Long id);
}
