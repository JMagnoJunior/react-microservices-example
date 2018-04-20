package com.magnojr.mservice.accommodation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Accommodation's image")
@Entity
public class ImageAccommodation {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@ApiModelProperty(hidden = true)
	private Long id;
	private String uri;

	public ImageAccommodation(String uri) {
		super();
		this.uri = uri;
	}

	public ImageAccommodation() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

}
