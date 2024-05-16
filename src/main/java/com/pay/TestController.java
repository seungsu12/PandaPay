package com.pay;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/hi")
	public ResponseEntity<String> testMethod(){
		return ResponseEntity.ok("hello");
	}
}
