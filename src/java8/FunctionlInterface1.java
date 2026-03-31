package java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class FunctionlInterface1 {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		/************************************************************************************/
		/*
		 * Predicate<Integer> evenNums = (n) -> { return n % 2 == 0; };
		 */

		Predicate<Integer> evenNums = new Predicate<Integer>() {
			@Override
			public boolean test(Integer n) {
				return n % 2 == 0;
			}
		};
		Boolean result = evenNums.test(5);
		System.out.println(result);

		// List<Integer> result2 =
		// list.stream().filter(evenNums).collect(Collectors.toList());
		List<Integer> result2 = list.stream().filter((n) -> evenNums.test(n)).collect(Collectors.toList());
		System.out.println(result2);
		/************************************************************************************/
		/*
		 * Consumer<Integer> consumer = (n) -> { System.out.print(n + " "); };
		 */
		Consumer<Integer> consumer = new Consumer<Integer>() {
			@Override
			public void accept(Integer n) {
				System.out.print(n + " ");
			}
		};
		System.out.print("Consumer example  ");
		// list.stream().forEach(consumer);
		list.stream().forEach((b) -> consumer.accept(b));
		/************************************************************************************/
		/*
		 * Supplier<Integer> sup =()->{ return 5; };
		 */

		Supplier<Integer> sup = new Supplier<Integer>() {
			@Override
			public Integer get() {
				return 5;
			}
		};
		System.out.println();
		System.out.println("Supplier example " + sup.get());
		/************************************************************************************/
		/*
		 * Function<Integer, Integer> fun = (n) -> { return n * 10; };
		 */
		Function<Integer, Integer> fun = new Function<Integer, Integer>() {

			@Override
			public Integer apply(Integer n) {
				return n * 10;
			}

		};
		// List<Integer> result3 = list.stream().map(fun).collect(Collectors.toList());
		List<Integer> result3 = list.stream().map((n) -> fun.apply(n)).collect(Collectors.toList());
		System.out.println(result3);

	}

}
