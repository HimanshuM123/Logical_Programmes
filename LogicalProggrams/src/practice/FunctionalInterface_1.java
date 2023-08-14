package practice;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterface_1 {

	public static void main(String[] args) {
		// predicate
		Predicate<Integer> p = (i) -> {
			return i % 2 == 0;
		};

		System.out.println(p.test(8));

		// consumer

		Consumer<String> c = (s) -> {
			System.out.println(s);
		};
		c.accept("consumer");
		
		//supplier
		
		Supplier<String> s = ()-> {
			return "I am supplier";
		};
		System.out.println(s.get());
		//Function
		
		Function<String, String> f = (fun)->{
			return fun.toUpperCase();
		};
		
		Function<String,String> f1 =String::toUpperCase;
		
		System.out.println(f.apply("function"));
		System.out.println(f1.apply("function1"));
	}

}
