package java8;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.Function;

public class F_FunctionalIntefaces {
	public static void main(String[] args) {
		
		//1
		Predicate<Integer> pred =(s)-> s % 2==0;
		System.out.println(pred.test(4));
		
		//2
		Consumer<String> cons=(s)-> System.out.println(s.toUpperCase());
		cons.accept("myString");
		
		//3
		Supplier<String> sup=() -> "supplier";
		System.out.println(sup.get());
		
		//4
		Function<String ,String> fun=(s) -> s.toUpperCase();
		System.out.println(fun.apply("uppercase"));
		
		
	}

}
