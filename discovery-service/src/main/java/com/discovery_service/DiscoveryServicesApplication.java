package com.discovery_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer //Enable the Eureka Server so other services can register and communication can happen.
public class DiscoveryServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryServicesApplication.class, args);
	}

}
