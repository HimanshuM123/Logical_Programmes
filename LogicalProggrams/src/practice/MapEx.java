package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapEx {
	public static void main(String[] args) {

		Map<Integer,String> hm = new HashMap<>();
		hm.put(1, "Java");
		hm.put(2, "C++");
		hm.put(3, "Go");
		hm.put(4, "Python");
		
		for(Map.Entry obj : hm.entrySet()) {
			System.out.println(obj.getKey() +"  "+obj.getValue());
		}
		System.out.println("========================================");
		List<String> list = new ArrayList<>();
		String str = "xvgacfacfasxacdxxdzdzdaxzadxsaxcdxcdxfcxacxxd";
		for(Character o: str.toCharArray()) {
			list.add(o.toString());
		}
		Map<String, Long> map = list
				.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		for(Map.Entry<String, Long> o : map.entrySet()) {
			System.out.println(o.getKey()+"  "+o.getValue());
		}	
	}
}
