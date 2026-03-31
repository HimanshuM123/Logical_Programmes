package number;


//Program to convert Roman
//Numerals to Numbers
import java.util.*;

public class RomanToInteger2 {
	
	private int romanToDecimal(String s) {
		
		Map<String , Integer> hm = new HashMap();
		hm.put("I", 1);
		hm.put("V", 5);
		hm.put("X", 10);
		hm.put("L", 50);
		hm.put("C", 100);
		hm.put("D", 500);
		hm.put("M", 1000);
		
		int ans=0;
		// IC ==99
		//CI=101
		
		for(int i=0; i<s.length();i++) {
			if(i < s.length()-1 && hm.get(s.charAt(i)+"")<hm.get(s.charAt(i+1)+"")) {
				ans = ans - hm.get(s.charAt(i)+"");
			}else {
				ans = ans + hm.get(s.charAt(i)+"");
			}
		}
	
		return ans;
	}
	
	
	
	 // Driver Code
	 public static void main(String args[])
	 {
		 RomanToInteger2 ob = new RomanToInteger2();

	     // Considering inputs given are valid
	     //String str = "MCMIV";
		// String str = "IC";
		 String str = "CIII";
	     System.out.println("Integer form of Roman Numeral"
	                        + " is "
	                        + ob.romanToDecimal(str));
	 }



}
