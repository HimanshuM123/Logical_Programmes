package algorithmsBasics;

import java.util.HashMap;
import java.util.Map;

public class CharCount {
	public static void main(String[] args) {
		String str="this is string with repeated characters";
		Map<Character,Integer> hm=new HashMap<>();
		str=str.replace(" ", "");
		char[] arr=str.toCharArray();
		for(int i=0;i<arr.length;i++) {
			if(hm.containsKey(arr[i])) {
				hm.put(arr[i], hm.get(arr[i])+1);
			}
			else {
				hm.put(arr[i], 1);
			}
		}
		System.out.println(hm);
	}

}
