package java8;

import java.util.function.Function;

public class F_FunctionExample {
	static Function<String, String> function = (name) -> name.toUpperCase();
	static Function<String, String> addSomeString = (name) -> name.concat("default");

	public static void main(String[] args) {
		System.out.println("Result is : " + function.apply("java"));
		System.out.println("result of andThen: " + function.andThen(addSomeString).apply("java"));
		System.out.println("result of compose: " + function.compose(addSomeString).apply("java"));
	}

}
