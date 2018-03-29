package com.magnojr.mservice.accommodation.accommodation.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Accommodation {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	private String name;
	@ManyToOne
    @JoinColumn(name = "id_location")
	private Location location;
	@ManyToOne
    @JoinColumn(name = "id_address")
	private Address address;
	private BigDecimal price;	
	@OneToMany
    @JoinColumn(name = "id_schedule")	
	private List<DateAvailability> schedule;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public List<DateAvailability> getSchedule() {
		return schedule;
	}

	public void setSchedule(List<DateAvailability> schedule) {
		this.schedule = schedule;
	}

	
	
}
