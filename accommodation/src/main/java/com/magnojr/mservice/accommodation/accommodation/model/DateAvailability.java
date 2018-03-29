package com.magnojr.mservice.accommodation.accommodation.model;

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
	//FIXME: Change this relation for manytomany
	@ManyToOne
    @JoinColumn(name = "id_guest")
	private Guest guest;
	@ManyToOne
    @JoinColumn(name = "id_schedule")
	private Accommodation accommodation;
	
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
	public Guest getGuest() {
		return guest;
	}
	public void setGuest(Guest guest) {
		this.guest = guest;
	}
	public Accommodation getAccommodation() {
		return accommodation;
	}
	public void setAccommodation(Accommodation accommodation) {
		this.accommodation = accommodation;
	}
	
	
	
	
}
