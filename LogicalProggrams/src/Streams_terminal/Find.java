package Streams_terminal;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Find {
	
	public static void main(String[] args) {
		List<String> list = Arrays.asList("A","B","C","D");

	    Optional<String> result = list.stream().findAny();
	    
	    System.out.println(result.get());
	    
	    List<String> list2 = Arrays.asList("A","B","C","D");

	    Optional<String> result2 = list2.stream().findFirst();
	    
	    System.out.println(result2.get());
	}

}
