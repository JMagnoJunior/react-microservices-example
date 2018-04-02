package com.magnojr.mservice.reservation.queue;

import java.io.Serializable;
import java.util.Date;

import com.magnojr.mservice.reservation.model.Reservation;

public final class ReservationMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long accommodationId;
	private Date begin;
	private Date end;

	// Default constructor is needed to deserialize JSON
	public ReservationMessage() {
	}

	public ReservationMessage(Reservation reservation) {
		this.accommodationId = reservation.getAccommodation_id();
		this.begin = reservation.getPeriodReserved().getBegin();
		this.end = reservation.getPeriodReserved().getEnd();
	}



	public Long getAccommodationId() {
		return accommodationId;
	}

	public void setAccommodationId(Long accommodationId) {
		this.accommodationId = accommodationId;
	}

	public Date getBegin() {
		return begin;
	}

	public void setBegin(Date begin) {
		this.begin = begin;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}