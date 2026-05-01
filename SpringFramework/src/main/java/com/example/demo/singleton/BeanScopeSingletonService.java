package com.example.demo.singleton;

import org.springframework.stereotype.Component;

@Component
public class BeanScopeSingletonService {

	public BeanScopeSingletonService() {
		System.out.println("BeanScopeSingletonService() instance created");
	}

}
