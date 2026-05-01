package com.example.demo.beanInjection;

import org.springframework.context.annotation.Bean;

public class PrototypeBean {
	
	
	 public PrototypeBean() {
	        System.out.println("Prototype instance created");
	    }
	
}
