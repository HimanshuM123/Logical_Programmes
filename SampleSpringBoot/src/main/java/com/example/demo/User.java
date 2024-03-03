package com.example.demo;

public class User {
	String name;
	String field;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public User(String name, String field) {
		super();
		this.name = name;
		this.field = field;
	}
	
	

}
