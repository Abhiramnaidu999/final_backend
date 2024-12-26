package com.coforge.project.state;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class NodalOfficerPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(NodalOfficerPortalApplication.class, args);
	}

}
