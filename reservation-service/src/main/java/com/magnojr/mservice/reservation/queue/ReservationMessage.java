package com.magnojr.mservice.reservation.queue;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.magnojr.mservice.reservation.model.Reservation;

public final class ReservationMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long reservationId;
	private Long accommodationId;
	private String begin;
	private String end;

	// Default constructor is needed to deserialize JSON
	public ReservationMessage() {
	}

	public ReservationMessage(Reservation reservation, Long accommodationid) {
		this.reservationId = reservation.getId();
		this.accommodationId = accommodationid;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		this.begin = reservation.getPeriodReserved().getBegin().format(formatter);
		this.end = reservation.getPeriodReserved().getEnd().format(formatter);
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



	public String getBegin() {
		return begin;
	}

	public void setBegin(String begin) {
		this.begin = begin;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}