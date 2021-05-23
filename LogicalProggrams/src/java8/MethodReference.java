package java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

interface Sayable {
	public void say();
}

public class MethodReference {
	public static void saySomething1() {
		System.out.println("Saysomething 1");
	}

	public static void saySomething2() {
		System.out.println("Saysomething 2");
	}

	public static void main(String[] args) {

		Sayable sayable1 = () -> saySomething1();
		// Sayable sayable1=MethodReference::saySomething1;
		Sayable sayable2 = MethodReference::saySomething2;
		sayable1.say();
		sayable2.say();

		List<String> al = Arrays.asList("a", "b", "A", "B");
		// al.sort((s1,s2)-> s1.compareToIgnoreCase(s2));
		al.sort(String::compareToIgnoreCase);
		System.out.println(al);

		//Function<String, Integer> stringToInteger = (String s) -> Integer.parseInt(s);
		Function<String,Integer> stringToInteger =Integer::parseInt;
		Integer int1 = stringToInteger.apply("5");
		System.out.println(int1);
	}

}
