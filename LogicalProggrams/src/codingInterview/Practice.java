package codingInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practice {
	
	public static void main(String[] args) {
		String [] arr = {"bella","label","roller"};
		List<String> res =commonChars(arr);
		System.out.println(res);
	}
	
	
	
	
	private static List<String> commonChars(String [] arr){
		List<String> res =new ArrayList<>();
		
		int [] min_freq = new int[26];
		Arrays.fill(min_freq, Integer.MAX_VALUE);
		
		System.out.println(Arrays.toString(min_freq));
		
		
		for(String obj: arr ) {
			int [] fre_arr =  new int[26];
			
			for(int i=0; i< obj.length(); i++) {
				fre_arr[obj.charAt(i)-'a']++;
			}
		//	System.out.println(Arrays.toString(fre_arr));
			
			for(int i=0; i<26;i++) {
				min_freq[i]= Math.min(min_freq[i],fre_arr[i]);
						
			}
			System.out.println(Arrays.toString(min_freq));
		}
		
		
		for(int i=0; i<26;i++) {
			while(min_freq[i]>0) {
				res.add(""+(char)(i+'a'));
				min_freq[i]--;
			}
		}
		
		
		
		
		
		return res;
	}

}








//["bella","label","roller"] => ["e","l","l"]