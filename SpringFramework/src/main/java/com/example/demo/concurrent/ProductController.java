package com.example.demo.concurrent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping("/getProducts/{i}")
	private void getProducts(@PathVariable int i) {
		service.getProductById(i);
	}

}

/*
Thread: http-nio-8080-exec-1; bean instance: com.example.demo.concurrent.ProductService@f4dd518; product id: 1 has the name: Product 1
Thread: http-nio-8080-exec-2; bean instance: com.example.demo.concurrent.ProductService@f4dd518; product id: 2 has the name: Product 2




*/