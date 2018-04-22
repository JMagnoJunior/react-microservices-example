package com.magnojr.mservice.reservation.queue;

import java.io.Serializable;

public class RegisterScheduleMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long reservationId;
	private Boolean success;

	public RegisterScheduleMessage(long l, boolean b) {
		this.reservationId = l;
		this.success = b;
	}

	public RegisterScheduleMessage() {
		super();
	}

	public Long getReservationId() {
		return reservationId;
	}

	public void setReservationId(Long reservationId) {
		this.reservationId = reservationId;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

}
