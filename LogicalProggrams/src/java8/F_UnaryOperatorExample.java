package java8;

import java.util.function.UnaryOperator;

public class F_UnaryOperatorExample {
//use this when input & output has same type like String in this case
	static UnaryOperator<String> unary = (s) -> s.concat("default");

	public static void main(String[] args) {
		System.out.println(unary.apply("Java"));
	}
}
