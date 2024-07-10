package java8;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class F_FunctionExample {
	static Function<String, String> function = (name) -> name.toUpperCase();
	static Function<String, Integer> anotherFunction = (obj) -> Integer.parseInt(obj); 
	static Function<String, String> addSomeString = (name) -> name.concat("default");
	static BiFunction<String, String, Integer> biFunction = (str1,str2) -> Integer.parseInt(str1+str2);
	static BinaryOperator<String> binaryOperator = (str1,str2)-> str1+str2;
	static UnaryOperator<String> unaryOperator = (str)-> str.toUpperCase();

	public static void main(String[] args) {
		System.out.println("Result is : " + function.apply("java"));
		System.out.println("result of andThen: " + function.andThen(addSomeString).apply("java"));
		System.out.println("result of compose: " + function.compose(addSomeString).apply("java"));
		System.out.println("Result of another function "+anotherFunction.apply("7"));
		System.out.println("The result of BiFunction is "+biFunction.apply("2", "3"));
		System.out.println("The result of BinaryOperator is "+binaryOperator.apply("JA", "VA"));
		System.out.println("The result of UnaryOperator is "+unaryOperator.apply("html"));
	}

}


// Function -> Unary operator
//BiFunction -> Binary Operator