package com.magnojr.mservice.reservation;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"com.magnojr.mservice.reservation.repositoryresource"})
@EntityScan(basePackages = {"com.magnojr.mservice.reservation.model"})
public class JpaDataConfiguration {

}
