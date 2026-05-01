package com.example.demo.singleton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	
//	@Autowired
//	private BeanScopeRequest beanScopeRequest;
	
	@Autowired
	private BeanScopeSession beanScopeSession;
	
//	@GetMapping("/message")
//	public String getMessage() {
//		return beanScopeRequest.getMessage();
//	}
	
	@GetMapping("/sessionMessage")
	public String getMessage2() {
		return beanScopeSession.getMessage();
	}

}
