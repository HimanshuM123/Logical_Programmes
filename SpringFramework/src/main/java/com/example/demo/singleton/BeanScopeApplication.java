package com.example.demo.singleton;

import java.time.LocalDateTime;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

//Real time use ->create single bean for entire application used in caching, shared resource
@Component
@Scope(value=WebApplicationContext.SCOPE_APPLICATION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class BeanScopeApplication {
	
	private String message;

	public BeanScopeApplication() {
		System.out.println("BeanScopeApplication() called..."+LocalDateTime.now());
		this.message = "This is a session scope bean";
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
