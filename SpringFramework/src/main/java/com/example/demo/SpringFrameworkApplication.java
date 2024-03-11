package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.client.RestTemplateAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.Assert;

import com.example.demo.DI.TextEditor;
import com.example.demo.beanInjection.AppConfig;
import com.example.demo.beanInjection.PrototypeBean;
import com.example.demo.beanInjection.SingletonBean;
import com.example.demo.pojo.Car;
import com.example.demo.scope.MessageService;
import com.example.demo.scope2.ClassA;
import com.example.demo.scope2.ClassB;
import com.example.demo.singleton.BeanScopePrototypeService;
import com.example.demo.singleton.BeanScopeSingletonService;


@SpringBootApplication
public class SpringFrameworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringFrameworkApplication.class, args);

		/*
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringFrameworkApplication.class);
		Car car = ctx.getBean(Car.class);
		System.out.println(car.getEngineData());
		*/
		
		//bean scope
		
	
//		 AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext(SpringFrameworkApplication.class);
//	        MessageService messageService = context.getBean(MessageService.class);
//	        messageService.setMessage("TwitterMessageService Implementation");
//	        System.out.println(messageService.getMessage());
//	  
//	        MessageService messageService1 = context.getBean(MessageService.class);
//	        System.out.println(messageService1.getMessage());
//	        context.close();
	        
	      
		
		/*
		 AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext(SpringFrameworkApplication.class);
		 TextEditor textEditor = (TextEditor)context.getBean(TextEditor.class);
		 textEditor.spellCheck();
		 */
		
		//bean scope2
		/*
		 AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext(SpringFrameworkApplication.class);
		 ClassA classA = (ClassA)context.getBean(ClassA.class);
		 ClassB classB = (ClassB)context.getBean(ClassB.class);
		 classA.setMessage("test");
		 //System.out.println("testing scope...."+classA.getMessage());
		 classA.spellCheck();
		 System.out.println("testing sub class scope  "+ classB.getMethodB());
		
		 ClassA classA2 = (ClassA)context.getBean(ClassA.class);
		 ClassB classB2 = (ClassB)context.getBean(ClassB.class);
		 classA2.spellCheck();
		 System.out.println("testing sub class scope  "+ classB2.getMethodB());
		 
		
	      context.close();
	      */
		
		
		//Both beans were initialized only once, at the startup of the application context.

//		 AnnotationConfigApplicationContext context 
//	      = new AnnotationConfigApplicationContext(AppConfig.class);
//	    
//	    SingletonBean firstSingleton = context.getBean(SingletonBean.class);
//	    PrototypeBean firstPrototype = firstSingleton.getPrototypeBean();
//	    
//	    // get singleton bean instance one more time
//	    SingletonBean secondSingleton = context.getBean(SingletonBean.class);
//	    PrototypeBean secondPrototype = secondSingleton.getPrototypeBean();

	   // Assert.isTrue(firstPrototype.equals(secondPrototype), "The same instance should be returned");
	    
		 AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext(SpringFrameworkApplication.class);
		 BeanScopeSingletonService service1 = context.getBean(BeanScopeSingletonService.class);
		 BeanScopeSingletonService service2 = context.getBean(BeanScopeSingletonService.class);
		 BeanScopeSingletonService service3 = context.getBean(BeanScopeSingletonService.class);
		 
		 BeanScopePrototypeService prototype1 = context.getBean(BeanScopePrototypeService.class);
		 BeanScopePrototypeService prototype2 = context.getBean(BeanScopePrototypeService.class);
		 BeanScopePrototypeService prototype3 = context.getBean(BeanScopePrototypeService.class);
	}

}
