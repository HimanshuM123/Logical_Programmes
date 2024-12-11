package practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Practice4 {
	
	public static void main(String[] args) {
		String str = "agsusyuw";
		
		String res=
		str.chars().mapToObj(c ->(char)c).sorted((a,b)->-1).map(a -> a+"").collect(Collectors.joining());
		
		System.out.println(res);
		
		
	}

}
