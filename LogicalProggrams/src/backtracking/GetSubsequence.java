package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetSubsequence {
	
	public static void main(String[] args) {
		String str ="abc";
		
		ArrayList<String> res = getSubsequence(str);
		System.out.println(res);
	}
	
	private static ArrayList<String> getSubsequence(String str){
		if(str.length()==0) {
			ArrayList<String> blank = new ArrayList<>();
			blank.add("");
			return blank;
		}
		
		char ch = str.charAt(0);
		String rest = str.substring(1);
		ArrayList<String> list = getSubsequence(rest);
		
		ArrayList<String> result = new ArrayList<>();
		for(String obj :list) {//- +E(bc)
			result.add(""+obj);
		}
		for(String obj :list) {//a +E(bc)
			result.add(ch+obj);
		}
		return result;
		
	}

}


/*
abc
- +E(bc)
a +E(bc)

  ---
  --c
  -b-
  -bc
  a--
  a-c
  ab-
  abc
  



*/