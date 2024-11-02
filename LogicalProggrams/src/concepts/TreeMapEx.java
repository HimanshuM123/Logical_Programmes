package concepts;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapEx {
	public static void main(String[] args) {
		Map<Integer,String> hm = new TreeMap<>();
		hm.put(5, "A");
		hm.put(8, "H");
		hm.put(2, "I");
		hm.put(9, "Y");
		
		hm.forEach((K,V)-> System.out.println(K+" "+V));
		/*
	    2 I
		5 A
		8 H
		9 Y

		 */
		
		Map<String,Integer> hm2 = new TreeMap<>();
		hm2.put("agf", 1);
		hm2.put("adf", 5);
		hm2.put("aaf", 8);
		hm2.put("apf", 3);
		
		hm2.forEach((K,V)-> System.out.println(K+" "+V));
		/*
		 aaf 8
		adf 5
		agf 1
		apf 3
		 */
		 
	}

}
