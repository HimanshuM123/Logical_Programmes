package com.example.demo.dependencyInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

	// Field level DI
	@Autowired
	private OrderRepository orderRepository;

	
	//Setter DI
	@Autowired
	public void setOrderRepository(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}


	//constructor DI
	//used for mandatory DI
	@Autowired //optional for one field
	public OrderService(OrderRepository orderRepository) {
		super();
		this.orderRepository = orderRepository;
	}

	
	
}
