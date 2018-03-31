package com.magnojr.mservice.file;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.magnojr.mservice.file.properties.StorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({StorageProperties.class})
public class FileServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileServiceApplication.class, args);
	}
}
