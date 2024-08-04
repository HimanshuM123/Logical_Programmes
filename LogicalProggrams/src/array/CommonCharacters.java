package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonCharacters {
	public static void main(String[] args) {
		//String [] arr = {"bella","label","roller"};
		String [] arr = {"bbbb","bbbbb"};
		List<String> res =commonChars(arr);
		System.out.println(res);
	}
	
	private static List<String> commonChars(String[] str){
		List<String> common_chars = new ArrayList<>();
		int [] min_freq = new int[26];
		Arrays.fill(min_freq, Integer.MAX_VALUE); //fill array with max values
		
		for(String current_string : str) {
			int [] char_freq = new int[26];
			
			for(char c : current_string.toCharArray()) {
				char_freq[c-'a']++;
			}
			for(int i=0; i<26;i++) {
				min_freq[i] = Math.min(min_freq[i], char_freq[i]);
			}
		}
		
		for(int i=0; i<26;i++) {
			while(min_freq[i]>0) {
				common_chars.add(""+(char)(i+'a'));
				min_freq[i]--;
			}
			
		}
		return common_chars;
	}
}

/*
 * 
 * ["bella","label","roller"] => ["e","l","l"]
 * 
 * 
 */