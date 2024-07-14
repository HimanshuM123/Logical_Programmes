package myPkg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Practice {

	public static void main(String[] args) {

		int [] numArr = {100,90,50,40,10,9,5,4,1};
		
		String [] romanArr = {"C","XC","L","XL","X","IX","V","IV","I"};
		
		
		
	// XXIV -> 24
		//IX  9 
		//XI = 11
		
		Map<String , Integer> hm = new HashMap<>();
		hm.put("I", 1);
		hm.put("IV", 4);
		hm.put("V", 5);
		hm.put("IX", 9);
		hm.put("X", 10);
		hm.put("XL", 40);
		hm.put("L", 50);
		hm.put("XC", 90);
		hm.put("C", 100);
		
		
		
		
		String roman ="XXIV";	
		int ans =0;
		for(int i =0 ; i< roman.length();i++) {
			if(i+1<roman.length() && hm.get(roman.charAt(i)+"") < hm.get(roman.charAt(i+1)+"")) {
				ans = ans - hm.get(roman.charAt(i)+"");
			}else {
				ans = ans + hm.get(roman.charAt(i)+"");
			}
		}
		
		System.out.println(ans);
		
	}
}
