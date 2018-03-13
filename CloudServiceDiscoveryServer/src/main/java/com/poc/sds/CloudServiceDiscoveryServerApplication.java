package com.poc.sds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CloudServiceDiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudServiceDiscoveryServerApplication.class, args);
	}
}
