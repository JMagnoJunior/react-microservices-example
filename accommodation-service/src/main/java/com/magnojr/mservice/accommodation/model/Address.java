package com.magnojr.mservice.accommodation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Accommodation's address")
@Entity
public class Address {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@ApiModelProperty(hidden = true)
	private Long id;
	private String zipCode;
	private String city;
	private String state;
	private String streetAddress;

	public Address(String zipCode, String city, String state, String streetAddress) {
		super();
		this.zipCode = zipCode;
		this.city = city;
		this.state = state;
		this.streetAddress = streetAddress;
	}

	public Address() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

}
