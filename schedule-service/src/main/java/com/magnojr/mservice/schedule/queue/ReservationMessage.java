package com.magnojr.mservice.schedule.queue;

import java.io.Serializable;
import java.util.Date;

public final class ReservationMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long reservationId;
	private Long accommodationId;
	private Date begin;
	private Date end;

	// Default constructor is needed to deserialize JSON
	public ReservationMessage() {
	}

	public Long getReservationId() {
		return reservationId;
	}

	public void setReservationId(Long reservationId) {
		this.reservationId = reservationId;
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

	public String toString() {
		return "ReservationMessage : " + this.accommodationId + " - " + this.begin + " - " + this.end;
	}

}