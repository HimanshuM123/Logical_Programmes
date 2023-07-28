package java8;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaceEx {
	public static void main(String[] args) {
		//Predicate
		Predicate<Integer> pd =(i)-> i==0;
		System.out.println(pd.test(6));
		
		//consumer
		Consumer<String> c = (s) -> System.out.println(s);
		c.accept("This is consumer");
			
		//Supplier
		Supplier<String> s = ()-> {
			return "supplier";
		};
		System.out.println(s.get());
		
		//function
		Function<String, String> fun = (s1) -> {
			return s1.toUpperCase();
		};		
		System.out.println(fun.apply("mango"));
		
		//Biconsumer
		BiConsumer<String, String> bc = (s1,s2)->{
			System.out.println(s1+" "+s2);
		};
		bc.accept("consumer1", "consumer2");
		
		//BiFuntion
		BiFunction<String, String, String> bf =(s1,s2)->{
			return s1.toUpperCase().concat(s2);
		};
		System.out.println(bf.apply("java", "python"));
		
	}

}
