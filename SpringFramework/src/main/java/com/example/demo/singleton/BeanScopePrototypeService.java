package com.example.demo.singleton;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class BeanScopePrototypeService {

	public BeanScopePrototypeService() {
		System.out.println("BeanScopePrototypeService() instance created");
	}

}
