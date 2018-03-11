package com.poc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class CloudController {

	
	 @Value("${welcome.message}")
	 private String message;
	 
	 
	 @RequestMapping("/testMessage")
	 ResponseEntity<String> getMessage() {
	        return  new ResponseEntity<>(this.message, HttpStatus.OK);
	   }
}
