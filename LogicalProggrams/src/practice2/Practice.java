package practice2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Practice {
	public static void main(String[] args) {
	
	Predicate<Integer> p = (i) -> {
		return i%2==0;
	}	;
	
	boolean result =p.test(4);
	System.out.println(result);
	
	Consumer<String> c = (con)->{
		System.out.println(con);
	};
		
	c.accept("Hi..consumer");
	
	Supplier<String> sup =()->{
		return "Supplier....";
	};
	
	String su = sup.get();
	System.out.println(su);
	
	Function<Integer, String> fun = (i)->{
		return String.valueOf(i);
	};
	
	System.out.println(fun.apply(6));
	
	
	}
}
