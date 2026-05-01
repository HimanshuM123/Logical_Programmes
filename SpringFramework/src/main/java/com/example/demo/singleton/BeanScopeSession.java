package com.example.demo.singleton;

import java.time.LocalDateTime;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

//Real time use ->store user authentication info or user specific data in session object
@Component
@Scope(value=WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class BeanScopeSession {
	
	private String message;

	public BeanScopeSession() {
		System.out.println("BeanScopeSession() called..."+LocalDateTime.now());
		this.message = "This is a session scope bean";
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
