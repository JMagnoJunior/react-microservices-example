package com.magnojr.mservice.reservation.repositoryresource;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.magnojr.mservice.reservation.model.Reservation;

@RepositoryRestResource(collectionResourceRel = "reservations", path = "reservations")
public interface ReservationRepository extends PagingAndSortingRepository<Reservation, Long>,CrudRepository<Reservation, Long> {

}
