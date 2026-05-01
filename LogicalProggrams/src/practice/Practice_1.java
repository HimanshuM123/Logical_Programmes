package practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Practice_1 {
	
	public static void main(String[] args) {
		 List<Integer> intList = Arrays.asList(4,6,2,1,3,5);
		Integer res= intList.stream().max((a,b)-> a-b).get();
		System.out.println(res);
		 
		
		List<Integer> reslt =	intList.stream().sorted((a,b)->b-a).collect(Collectors.toList());
		System.out.println(reslt);
		
		Map<Integer, String> hm =  new HashMap<>();
		hm.put(4,"r");
		hm.put(6,"a");
		hm.put(8,"h");
		hm.put(45,"c");
		hm.put(2,"z");
		
		hm.entrySet().stream().sorted((a,b)-> a.getValue().compareTo(b.getValue())).forEach(x -> System.out.println(x.getKey()+" "+x.getValue()));
		System.out.println("-----------------------------");
		hm.entrySet().stream().sorted((a,b)-> a.getKey()-b.getKey()).forEach(y-> System.out.println(y.getKey()+" "+y.getValue()));
		
		
		List<Integer> list = Arrays.asList(10, 15, 8, 49, 25, 98, 32);
		
		List<Integer> result0 = list.stream().filter(a -> a%2==0).collect(Collectors.toList());
		 System.out.println(result0);
		 
		//Numbers starts with 1
			List<Integer> list2= Arrays.asList(2,11,14,67,4,3,18,100);
			List<Integer> list_res=	list2.stream().map(a -> a+"").filter(b-> b.startsWith("1")).map(c -> Integer.parseInt(c)).collect(Collectors.toList());
			System.out.println(list_res);
			
			
			//Duplicate Elements
			List<Integer> list3 = Arrays.asList(3,6,6,7,3,8,9,8);
			Set<Integer> set = new HashSet<>();
			
			List<Integer> resz=	list3.stream().filter(a -> !set.add(a)).collect(Collectors.toList());
			System.out.println(resz);
			Set<Integer> set2 = new HashSet<>();
			
			System.out.println("-----------------------------");
			System.out.println(set2.add(2));
			System.out.println(set2.add(2));
			System.out.println("-----------------------------");
			
			List<Integer> intList1 = Arrays.asList(1, 2, 3);
			List<Integer> intList2 = Arrays.asList(4, 5, 6);
			List<Integer> intList3 = Arrays.asList(7, 8, 9);
			List<List<Integer>> integerList = Arrays.asList(intList1, intList2, intList3);
			System.out.println(integerList);
			List<Integer> res_flat=	integerList.stream().flatMap(y -> y.stream()).collect(Collectors.toList());
			System.out.println(res_flat);
			
			
			
			
			
		
	}

}
