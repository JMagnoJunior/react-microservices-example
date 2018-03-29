package com.magnojr.mservice.reservation.bean;

import java.math.BigDecimal;

public class AvailabilityAndPrice {

	private boolean availible;
	private BigDecimal price;

	public boolean isAvailible() {
		return availible;
	}

	public void setAvailible(boolean availible) {
		this.availible = availible;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
