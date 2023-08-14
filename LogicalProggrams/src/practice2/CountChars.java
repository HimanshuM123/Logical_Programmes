package practice2;

import java.util.HashMap;
import java.util.Map;

public class CountChars {
public static void main(String[] args) {
	String str = "abacdcabdcab";
	
	Map<Character,Integer> hm = new HashMap<>();
	
	for(int i=0; i< str.length();i++) {
		Character ch =str.charAt(i);
		if(hm.get(ch)==null) {
			hm.put(ch, 1);
		}else {
			hm.put(ch, hm.get(ch)+1);
		}
	}
	
	for(Map.Entry obj:hm.entrySet()) {
		System.out.println(obj.getKey()+ " -> "+obj.getValue());
	}
	
}
}
