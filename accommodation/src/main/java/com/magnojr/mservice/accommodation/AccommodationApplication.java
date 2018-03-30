package com.magnojr.mservice.accommodation;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "com.magnojr.mservice" })
// @EnableSwagger2
// @EnableAsync
// @EnableTransactionManagament
// @PropertySource("src/main/resource/")
public class AccommodationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccommodationApplication.class, args);
	}

	@PostConstruct
	void started() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}
	
	
}
