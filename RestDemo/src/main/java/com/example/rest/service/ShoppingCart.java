package com.example.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ShoppingCart {
	private List<String> items = new ArrayList<>();

	public void addItem(String item) {
		items.add(item);
		System.out.println("Item added... "+items+ "--->"+items.size());
	}

	public List<String> getItems() {
		return items;
	}
}