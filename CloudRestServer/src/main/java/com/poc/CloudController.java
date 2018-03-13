package com.poc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.beans.CloudConfigBean;

@RefreshScope
@RestController
public class CloudController {

	@Autowired
	ReloableProperties cloudProperties;
	
	 @Value("${welcome.message}")
	 private String message;
	 
	 
	 @RequestMapping("/testMessage")
	 ResponseEntity<String> getMessage() {
	        return  new ResponseEntity<>(this.message, HttpStatus.OK);
	   }
	 
	 @RequestMapping("/config")
	 ResponseEntity<CloudConfigBean> getCloudConfig(){
		 CloudConfigBean config=new CloudConfigBean();
		 config.setDbAssertion(this.cloudProperties.getDbAssertion());
		 config.setDbUrl(this.cloudProperties.getDbUrl());
		 config.setDbUsername(this.cloudProperties.getDbUsername());
		 
		 return  new ResponseEntity<>(config, HttpStatus.OK);
	 }
}
