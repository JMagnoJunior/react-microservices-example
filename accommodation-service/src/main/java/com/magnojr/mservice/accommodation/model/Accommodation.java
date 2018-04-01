package com.magnojr.mservice.accommodation.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Accommodation {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	@NotNull
	@Size(min=2, message="A accommodation's name should have at least 2 characters")
	private String name;
	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "id_location")
	private Location location;
	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "id_address")
	private Address address;
	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "id_image")
	private ImageAccommodation image;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}	

	public ImageAccommodation getImage() {
		return image;
	}

	public void setImage(ImageAccommodation image) {
		this.image = image;
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


	
}
