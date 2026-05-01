package streams_intermediate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMap {
	public static void main(String[] args) {
		List<Integer> intList1 = Arrays.asList(1, 2, 3);
		List<Integer> intList2 = Arrays.asList(4, 5, 6);
		List<Integer> intList3 = Arrays.asList(7, 8, 9);
		List<List<Integer>> integerList = Arrays.asList(intList1, intList2, intList3);
		System.out.println(integerList);//[[1, 2, 3], [4, 5, 6], [7, 8, 9]]

		List<Integer> flatMapResult = integerList.stream().flatMap(y -> y.stream()).collect(Collectors.toList());

		System.out.println(flatMapResult); //[1, 2, 3, 4, 5, 6, 7, 8, 9]


	}

}
