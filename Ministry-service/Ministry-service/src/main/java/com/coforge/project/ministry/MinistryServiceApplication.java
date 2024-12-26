package com.coforge.project.ministry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MinistryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MinistryServiceApplication.class, args);
	}

}
