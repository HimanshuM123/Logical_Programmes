package java8;

import java.util.function.Function;

public class MethodReferenceFunction {

	static Function<String, String> toUpperCaseLambda = (s) -> s.toUpperCase();
	static Function<String, String> toUpperCaseMethodRef = String::toUpperCase;

	public static void main(String[] args) {
		System.out.println(toUpperCaseLambda.apply("java"));
		System.out.println(toUpperCaseMethodRef.apply("java8"));
	}

}
