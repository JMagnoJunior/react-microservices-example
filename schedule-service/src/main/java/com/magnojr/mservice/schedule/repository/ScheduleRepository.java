package com.magnojr.mservice.schedule.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.format.annotation.DateTimeFormat;

import com.magnojr.mservice.schedule.model.Schedule;

@RepositoryRestResource(collectionResourceRel = "schedule", path = "schedules")
public interface ScheduleRepository
		extends PagingAndSortingRepository<Schedule, Long>, CrudRepository<Schedule, Long> {

	List<Schedule> findByIdAccommodation(@Param("id_accommodation") Long idAccommodation);	

	List<Schedule> findByDateAndIdAccommodation(
			@Param("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate start, @Param("id_accommodation") Long idAccommodation);

	List<Schedule> findByDateBetweenAndIdAccommodation(
			@Param("start") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate start,
			@Param("end") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end, @Param("id_accommodation") Long idAccommodation);

}
