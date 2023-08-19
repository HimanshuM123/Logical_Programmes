package myPkg;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DuplicateCharsInString {
	public static void main(String[] args) {
		String myString="andamaan";
		char[] arr=myString.toCharArray();
		Map<Character,Integer> hm=new HashMap<>();
		
		for(char obj:arr) {
			//if(hm.containsKey(obj)) {
			if(hm.get(obj)!=null) {
				hm.put(obj, hm.get(obj)+1);
			}
			else{
				hm.put(obj, 1);
			}
		}
		//System.out.print(hm);
		Set<Character> keys=hm.keySet();
		for(Character key:keys) {
			if(hm.get(key)>1) {
				System.out.print(key+" ");
			}
		}
	}
}
