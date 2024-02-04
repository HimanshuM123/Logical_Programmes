package Streams_terminal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class MinTest {
	public static void main(String[] args) {
		 List<String> stringList = new ArrayList<>();

	     stringList.add("one");
	     stringList.add("two");
	     stringList.add("three");
	     stringList.add("one");

	     Stream<String> stream = stringList.stream();

	     Optional<String> min = stream.min((val1, val2) -> {
	         return val1.compareTo(val2);
	     });

	     String minString = min.get();

	     System.out.println(minString);
	     
	     List<Integer> intList = Arrays.asList(1,2,3,4,5);
	    int min_num= intList.stream().min((a,b)-> a.compareTo(b)).get();
	    System.out.println(min_num);
	}
}
