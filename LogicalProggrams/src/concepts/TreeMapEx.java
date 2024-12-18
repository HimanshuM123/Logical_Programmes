package concepts;

import java.util.Collections;
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
		
		Map<Integer,String> hm_rev = new TreeMap<>(Collections.reverseOrder());
		
		hm_rev.put(5, "A");
		hm_rev.put(8, "H");
		hm_rev.put(2, "I");
		hm_rev.put(9, "Y");
		System.out.println("-----------------------------------");
		hm_rev.forEach((K,V)-> System.out.println(K+" "+V));
		
		Map<String,Integer> hm2 = new TreeMap<>();
		hm2.put("agf", 1);
		hm2.put("adf", 5);
		hm2.put("aaf", 8);
		hm2.put("apf", 3);
		System.out.println("-----------------------------------");
		hm2.forEach((K,V)-> System.out.println(K+" "+V));
		/*
		 aaf 8
		adf 5
		agf 1
		apf 3
		 */
		 
	}

}
