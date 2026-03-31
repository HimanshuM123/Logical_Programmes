package java8.interview;

import java.util.Arrays;
import java.util.List;

public class LastElement {

	// retrive last element
	public static void main(String[] args) {
		List<String> list = Arrays.asList("One", "Two", "Three", "Four", "Five");
		String result = list.stream().skip(list.size() - 1).findFirst().get();
		System.out.println(result);
	}

}
