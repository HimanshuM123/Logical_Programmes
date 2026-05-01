package com.example.rest.component;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class ComponentTest {
	
	
	int counter =0;

	ComponentTest(){
		this.counter = counter++;
	}
	public int getCounter() {
		counter++;
		return counter;
	}

//	public void setCounter(int counter) {
//		this.counter = counter++;
//	}
	

}
