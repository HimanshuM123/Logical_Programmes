package com.example.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.service.OrderService;
import com.example.rest.service.ShoppingCart;

@RestController
@RequestMapping("/cart")
public class ShoppingCartController {
	@Autowired
	private ApplicationContext context;
	@Autowired
	private OrderService orderService;

	@PostMapping("/add")
	public void addItem(@RequestParam String item) {
		ShoppingCart cart = context.getBean(ShoppingCart.class);
		cart.addItem(item);
	}

	@PostMapping("/checkout")
	public void checkout(@RequestParam String userId) {
		orderService.checkout(userId);
	}

}
