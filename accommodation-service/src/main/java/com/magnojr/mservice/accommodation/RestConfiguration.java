package com.magnojr.mservice.accommodation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
public class RestConfiguration extends RepositoryRestConfigurerAdapter {

	@Value("${max.page.size}") 
	private Integer maxPageSize;
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.setMaxPageSize(maxPageSize);
	}
}
