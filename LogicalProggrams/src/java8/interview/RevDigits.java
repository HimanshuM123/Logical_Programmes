package java8.interview;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RevDigits {
	public static void main(String[] args) {
		
		int number = 47932;

		int rev_num= Integer.parseInt(String.valueOf(number)
				.chars()
				.mapToObj(c -> (char)c)
				.sorted((a,b)->-1)
				.map(String::valueOf)
				.collect(Collectors.joining()));
		System.out.println(rev_num);//23974
		
		int asc_num= Integer.parseInt(String.valueOf(number)
				.chars()
				.mapToObj(c -> (char)c)
				.sorted((a,b)->b-a)
				.map(String::valueOf)
				.collect(Collectors.joining()));
		System.out.println(asc_num);//97432
		
		int desc_num= Integer.parseInt(String.valueOf(number)
				.chars()
				.mapToObj(c -> (char)c)
				.sorted((a,b)->a-b)
				.map(String::valueOf)
				.collect(Collectors.joining()));
		System.out.println(desc_num);//23479
	}

}
