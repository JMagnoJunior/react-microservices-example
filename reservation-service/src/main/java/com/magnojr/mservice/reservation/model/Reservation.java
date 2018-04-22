package com.magnojr.mservice.reservation.model;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Reservation {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "id_guest")
	private Guest guest;
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "id_period_reserved")
	private PeriodReserved periodReserved;
	@JsonProperty(access=Access.READ_ONLY)
	private Long accommodation_id;
	@JsonProperty(access = Access.READ_ONLY)
	private BigDecimal totalPrice;
	
	private StatusReservation status = StatusReservation.INITIAL;

	
	public Reservation(Guest guest, PeriodReserved periodReserved, Long accommodation_id, BigDecimal totalPrice) {
		super();
		this.guest = guest;
		this.periodReserved = periodReserved;
		this.accommodation_id = accommodation_id;
		this.totalPrice = totalPrice;
		this.status = StatusReservation.INITIAL;
	}
	
	public Reservation() {
		super();
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	public PeriodReserved getPeriodReserved() {
		return periodReserved;
	}

	public void setPeriodReserved(PeriodReserved periodReserved) {
		this.periodReserved = periodReserved;
	}

	public Long getAccommodation_id() {
		return accommodation_id;
	}

	public void setAccommodation_id(Long accommodation_id) {
		this.accommodation_id = accommodation_id;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public StatusReservation getStatus() {
		return status;
	}

	public void setStatus(StatusReservation status) {
		this.status = status;
	}

	public void waitingConfirmation() {
		this.status = StatusReservation.WAITING;
		
	}

	public void confirm() {
		this.status = StatusReservation.CONFIRMED;		
	}

	public void cancel() {
		// TODO Auto-generated method stub
		this.status = StatusReservation.CANCELLED;
	}
	
	

}
