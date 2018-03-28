package com.magnojr.mservice.accommodation.accommodation.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;

@Entity
public class AccommodationSchedule  {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	@OneToMany
	@JoinColumn(name = "id_schedule")
	private List<DateAvailability> availability;
		
	public AccommodationSchedule(){
		
	}

	public List<DateAvailability> getAvailability() {
		return availability;
	}

	public void setAvailability(List<DateAvailability> availability) {
		this.availability = availability;
	}

}
