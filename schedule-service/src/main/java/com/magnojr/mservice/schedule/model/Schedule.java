package com.magnojr.mservice.schedule.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

@Entity
public class Schedule {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="UTC")
	@NotNull
	private LocalDate date;
	@NotNull
	private Boolean avaliable;	
	@JsonProperty(access=Access.WRITE_ONLY)
	private Long idAccommodation;
	@NotNull
	private BigDecimal price;	
	
	public Schedule() {
		super();
	}
	
	public Schedule(@NotNull LocalDate date, @NotNull Boolean avaliable, Long accommodation,
			@NotNull BigDecimal price) {
		super();
		this.date = date;
		this.avaliable = avaliable;
		this.idAccommodation = accommodation;
		this.price = price;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}	

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Boolean getAvaliable() {
		return avaliable;
	}
	public void setAvaliable(Boolean avaliable) {
		this.avaliable = avaliable;
	}
	

	public Long getIdAccommodation() {
		return idAccommodation;
	}

	public void setIdAccommodation(Long idAccommodation) {
		this.idAccommodation = idAccommodation;
	}

	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public void reserved() {
		this.avaliable = false;		
	}
	
	
	
	
}
