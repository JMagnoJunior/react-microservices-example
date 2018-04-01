package com.magnojr.mservice.schedule.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class DateAvailability {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="UTC")
	@Temporal(TemporalType.DATE)
	@NotNull
	private Date date;
	@NotNull
	private Boolean avaliable;	
	private Long accommodation_id;
	@NotNull
	private BigDecimal price;	
	
	public DateAvailability() {
		super();
	}
	
	public DateAvailability(@NotNull Date date, @NotNull Boolean avaliable, Long accommodation,
			@NotNull BigDecimal price) {
		super();
		this.date = date;
		this.avaliable = avaliable;
		this.accommodation_id = accommodation;
		this.price = price;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Boolean getAvaliable() {
		return avaliable;
	}
	public void setAvaliable(Boolean avaliable) {
		this.avaliable = avaliable;
	}
	

	public Long getAccommodation_id() {
		return accommodation_id;
	}

	public void setAccommodation_id(Long accommodation_id) {
		this.accommodation_id = accommodation_id;
	}

	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	
	
	
}
