package myPkg;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DuplicateCharsInString {
	public static void main(String[] args) {
		String myString="andamaan";
		char[] arr=myString.toCharArray();
		Map<Character,Integer> hm=new HashMap<>();
		Map<Character,Integer> hm2=new HashMap<>();
		
		for(char obj:arr) {
			//if(hm.containsKey(obj)) {
			if(hm.get(obj)!=null) {
				hm.put(obj, hm.get(obj)+1);
			}
			else{
				hm.put(obj, 1);
			}
		}
		
		hm.forEach((k,v)->{
			if(hm.get(k)>1) {
				System.out.print(k+"  ");
			}
		});
		
		
		for (char obj : arr) {
			hm2.merge(obj, 1, Integer::sum);
		}
		System.out.println(hm2);// {a=4, d=1, m=1, n=2}
	}
}
