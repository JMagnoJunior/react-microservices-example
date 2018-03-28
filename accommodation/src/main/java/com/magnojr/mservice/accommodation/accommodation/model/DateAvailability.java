package com.magnojr.mservice.accommodation.accommodation.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class DateAvailability {
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Long id;
	private String date;
	private Boolean avaliable;
	//FIXME: Change this relation for manytomany
	@ManyToOne
    @JoinColumn(name = "id_guest")
	private Guest guest;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
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
	
	
}
