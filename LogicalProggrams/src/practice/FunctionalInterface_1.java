package practice;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterface_1 {

	public static void main(String[] args) {
		// predicate
		Predicate<Integer> p =(i)-> i%2==0;
		
		System.out.println(p.test(7));
			

		// consumer
		
		Consumer<String>  c=(str)-> System.out.println(str);
		c.accept("this is consumer");

		
		
		//supplier
		
		Supplier<String> s =()->"Supplier";
		String result = s.get();
		System.out.println(result);
		
		//Function
		
		Function<String, String> fun =(str)-> str.toUpperCase();
		System.out.println(fun.apply("abcd"));

		
		
	}

}
