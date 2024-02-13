package com.example.demo.beanInjection2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

	@Autowired
	PrototypeClass prototypeClass;
	
	@GetMapping("/get")
	public String getName() {
		System.out.println(prototypeClass);
		//System.out.println(getBean());
		return "Hello";
	}
	
//	@Lookup
//	public PrototypeClass getBean() {
//		return null;
//	}

}

/*
output 
com.example.demo.beanInjection2.PrototypeClass@505aa0fd
com.example.demo.beanInjection2.PrototypeClass@505aa0fd
com.example.demo.beanInjection2.PrototypeClass@505aa0fd

after injecting prototype to singleton its behaving singleton only
to behave like prototype we can use @Lookup

*/