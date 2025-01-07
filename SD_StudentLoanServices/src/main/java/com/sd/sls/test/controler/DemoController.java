package com.sd.sls.test.controler;

/*
 * @Author: Abhishek Vishwakarma
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sd.sls.test.service.IDemoService;

@RestController
public class DemoController {

	@Autowired
	IDemoService demoService;

	@GetMapping("/test")
	public ResponseEntity<String> testMethod() {
		if (demoService.testMethod()) 
		{
			return ResponseEntity.ok("Demo is Working");
		} 
		else 
		{
			return new ResponseEntity<>("Demo Not Found", HttpStatus.BAD_REQUEST);
		}

	}

}
