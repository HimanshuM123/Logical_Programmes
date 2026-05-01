package java8Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamMinMaxExample {
	
	public static int findMaxValue(List<Integer> integerList) {
	return	integerList.stream()
		.reduce(0,(x,y)-> x>y?x:y);
		
	}
	
	public static Optional<Integer> findMinValue(List<Integer> integerList) {
		return	integerList.stream()
			.reduce((x,y)-> x<y?x:y);
			
		}

	public static void main(String[] args) {

		List<Integer> integerList = Arrays.asList(6, 7, 8, 9, 10);
		System.out.println("max value is "+findMaxValue(integerList));
		
		Optional<Integer> minValueOptional=findMinValue(integerList);
		if(minValueOptional.isPresent()) {
		System.out.println("min value is "+findMinValue(integerList).get());
		}
		else {
			System.out.println("No input passed");
		}
	}
}
