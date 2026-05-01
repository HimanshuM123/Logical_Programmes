package com.example.demo.singleton;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

//Real-time use to store form data info or user specific info
@Component
@Scope(value=WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class BeanScopeRequest {
	
	private String message;

	public BeanScopeRequest() {
		System.out.println("BeanScopeRequest() called...");
		this.message = "This is a request scope bean";
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
