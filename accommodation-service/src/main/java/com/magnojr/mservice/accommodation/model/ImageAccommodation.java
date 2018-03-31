package com.magnojr.mservice.accommodation.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ImageAccommodation {

	@Id
	private Long id;
	private String uri;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ImageAccommodation() {
		super();

	}

	public ImageAccommodation(String uri) {
		super();
		this.uri = uri;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

}
