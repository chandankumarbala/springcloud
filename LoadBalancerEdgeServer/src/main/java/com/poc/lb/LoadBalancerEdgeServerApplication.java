package com.poc.lb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class LoadBalancerEdgeServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoadBalancerEdgeServerApplication.class, args);
	}
}


/*
 Zuul is a JVM-based router and server-side load balancer from Netflix.
Authentication
Insights
Stress Testing
Canary Testing
Dynamic Routing
Service Migration
Load Shedding
Security
Static Response handling
Active/Active traffic management

*/