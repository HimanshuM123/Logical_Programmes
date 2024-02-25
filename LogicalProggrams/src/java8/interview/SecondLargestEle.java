package java8.interview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SecondLargestEle {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(4, 9, 1, 5, 0);

		int result = list.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
		System.out.println(result);

	}
}
