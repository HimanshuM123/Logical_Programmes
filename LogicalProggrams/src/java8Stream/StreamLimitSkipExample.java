package java8Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamLimitSkipExample {
	
	
	public static Optional<Integer> limit(List<Integer> integerList){
		
	return	integerList.stream()
		.limit(2)//limits the operation to 2 values
		//.reduce((x,y)->x+y);
		.reduce(Integer::sum);
	}
	
	public static Optional<Integer> skip(List<Integer> integerList){
		
		return	integerList.stream()
			.skip(3)//skips the operation to 3 values
			.reduce(Integer::sum);//passes 9,10
		}
	
	public static void main(String[] args) {
		List<Integer> integerList = Arrays.asList(6, 7, 8, 9, 10);
		
		Optional<Integer> sum=limit( integerList);
		if(sum.isPresent()) {
			System.out.println("The sum is "+sum.get());
		}
		
		Optional<Integer> skipsum=skip( integerList);
		
		if(skipsum.isPresent()) {
			System.out.println("The skip sum is "+skipsum.get());
		}
		
	}

}
