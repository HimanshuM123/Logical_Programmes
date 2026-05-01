package com.example.demo.DI;

import org.springframework.stereotype.Component;

@Component
public class SpellChecker {
	
	String name ;
	SpellChecker(String name){
		this.name = name;
	}
	
	   public SpellChecker(){
	      System.out.println("Inside SpellChecker constructor." );
	   }
	   public void checkSpelling(){
	      System.out.println("Inside checkSpelling." );
	   }
	}