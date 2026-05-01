package java8.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortBySecondDigit {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(88, 23, 15, 11, 90, 67);

		List<Integer> result = list.stream().sorted((a, b) -> a % 10 - b % 10).collect(Collectors.toList());

		System.out.println(result);

	}

}
//[90, 11, 23, 15, 67, 88]
