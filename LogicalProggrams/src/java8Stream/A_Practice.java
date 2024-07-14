package java8Stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class A_Practice {
	public static void main(String[] args) {
		
		
		
		Function<String,String> fun = (str)->{
			return str.toUpperCase();
		};
		
		System.out.println(fun.apply("acsfdfdgdh"));
		
		BiFunction<String, String, Integer> BiFun = (a,b)->{
			return Integer.parseInt(a+b);
		};
		
		System.out.println(BiFun.apply("4", "6"));
		
		BinaryOperator<String> BiOp = (str1,str2)->{
			return str1+str2;
		};
		
		System.out.println(BiOp.apply("a", "bcd"));
		
		UnaryOperator<String> u = (str)->{
			return str.toLowerCase();
		};
		
		System.out.println(u.apply("HUSSHDUDUHSUJ"));
	
	
	}
}
