package com.magnojr.mservice.schedule.queue;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

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
	
	public LocalDate getBeginFormated(){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return LocalDate.parse(this.begin, formatter);
	}

	public void setBegin(String begin) {
		this.begin = begin;
	}

	public String getEnd() {
		return end;
	}
	
	public LocalDate getEndFormated(){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return LocalDate.parse(this.end, formatter);
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String toString() {
		return "ReservationMessage : " + this.accommodationId + " - " + this.begin + " - " + this.end;
	}

}