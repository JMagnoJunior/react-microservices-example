package com.magnojr.mservice.accommodation;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"com.magnojr.mservice.accommodation.repositoryresource"})
@EntityScan(basePackages = {"com.magnojr.mservice.accommodation.model"})
public class JpaDataConfiguration {

}
