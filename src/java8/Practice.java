package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import java8Stream.Employee;



public class Practice {
	
	
	public static void main(String[] args) {
		List<Integer> list4 = Arrays.asList(4,8,89,34,67);
		
	Integer res=	list4.stream().max((a,b)-> a-b).get();
	System.out.println(res);
	}
	
	
}
