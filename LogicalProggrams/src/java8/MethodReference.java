package java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

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

	//	Sayable sayable1 = () -> System.out.println("Saysomething 1");
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
		
		
		List<Integer> numbers1 = Arrays.asList(3,8,1,56,23,5,9,0,32);
		List<Integer> sortedNumber1=numbers1.stream()
				.sorted((a,b)-> a.compareTo(b)).collect(Collectors.toList());
		System.out.println(sortedNumber1);
		
		
		List<Integer> numbers2 = Arrays.asList(5,34,1,7,38,3,8,98,3);
		List<Integer> sortedNumber2=numbers2.stream()
				.sorted(Integer::compareTo).collect(Collectors.toList());
		System.out.println(sortedNumber2);
			
		
		
	}

}
