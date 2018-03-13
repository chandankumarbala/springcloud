package com.poc;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableEurekaClient
public class CloudConfig{
	
	 
}



/*@Configuration
public class CloudConfig extends WebSecurityConfigurerAdapter{
	
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.antMatcher("/actuator/**").authorizeRequests().anyRequest().permitAll();
	    }
}*/
