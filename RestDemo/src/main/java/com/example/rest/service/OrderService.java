package com.example.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
	@Autowired
	private ApplicationContext context; // To get prototype beans

	public void checkout(String userId) {
// Get a new instance of ShoppingCart for the current user
		ShoppingCart cart = context.getBean(ShoppingCart.class);
// Perform checkout logic
		System.out.println("Checking out items: " + cart.getItems());
	}
}