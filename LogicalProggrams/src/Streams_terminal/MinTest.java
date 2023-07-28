package Streams_terminal;
import java.util.ArrayList;
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
	}
}
