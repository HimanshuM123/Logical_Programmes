package streams_intermediate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


//Debugging purpose
public class Peek {
	public static void main(String[] args) {
		List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		List<Integer> result = intList.stream().filter(o -> o % 2 != 0).filter(o -> o % 5 != 0)
				.peek(e -> System.out.println("Filtered value: " + e)).collect(Collectors.toList());

	}

}
