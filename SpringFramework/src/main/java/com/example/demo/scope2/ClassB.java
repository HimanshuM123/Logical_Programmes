package com.example.demo.scope2;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ClassB {
	String name ;
	String msg;
	
	ClassB(String name){
		this.name = name;
	}
	
	   public ClassB(){
	      System.out.println("Inside ClassB constructor." );
	   }
	   public void classBMethod(String msg){
		  this.msg=msg;
	      System.out.println("Inside ClassB method...."+msg );
	   }
	   
	   public String getMethodB() {
		   return this.msg;
	   }
	   
	  
	   
}

