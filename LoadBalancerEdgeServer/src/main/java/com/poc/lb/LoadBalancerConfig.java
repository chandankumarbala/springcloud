package com.poc.lb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.poc.lb.filters.BasicSecurityFilter;

@Configuration
public class LoadBalancerConfig {

	
	 @Bean
	  public BasicSecurityFilter getBasicSecurityFilter() {
	    return new BasicSecurityFilter();
	  }
}
