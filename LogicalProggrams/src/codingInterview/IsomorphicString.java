package codingInterview;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicString {

	
	public static void main(String[] args) {
		String str1 ="egg";
		String str2= "add";
		
		boolean result =isIsomorohic(str1,str2);
		
		System.out.println(result);
	}
	
	
	private static boolean isIsomorohic(String str1, String str2) {
		
		if(str1.length()!= str2.length())
		{
			return false;
		}
		
		Map<Character,Character> hm = new HashMap<Character,Character>();
		
		
		for(int i=0; i<str1.length();i++) {
			Character ch1 =str1.charAt(i);
			Character ch2 =str2.charAt(i);
			if(hm.get(ch1)==null) {
				hm.put(ch1, ch2); // a->e, g->d
			}else {
				Character ch3 = hm.get(ch1);
				if(ch3!=ch2) {
					return false;
				}
				
			}
			
		}
		
		return true;
		
	}
}
