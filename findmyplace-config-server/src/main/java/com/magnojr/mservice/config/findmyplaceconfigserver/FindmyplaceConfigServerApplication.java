package com.magnojr.mservice.config.findmyplaceconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class FindmyplaceConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FindmyplaceConfigServerApplication.class, args);
	}
}
