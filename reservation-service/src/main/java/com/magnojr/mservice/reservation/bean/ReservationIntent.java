package com.magnojr.mservice.reservation.bean;

import java.math.BigDecimal;

public class ReservationIntent {

	private boolean available;
	private BigDecimal price;

	public ReservationIntent() {
		super();
	}

	public ReservationIntent(boolean available, BigDecimal price) {
		super();
		this.available = available;
		this.price = price;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailible(boolean availible) {
		this.available = availible;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
