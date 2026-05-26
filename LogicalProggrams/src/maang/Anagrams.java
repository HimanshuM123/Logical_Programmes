package maang;

public class Anagrams {
	
	public static void main(String[] args) {
		boolean result = isAnagram("anagram","aganmar");
		
		System.out.println(result);
	}
	
	
	private static boolean isAnagram(String str1, String str2) {
		if(str1.length()!=str2.length()) {
			return false;
		}
		
		int [] count = new int[26];
		for(char ch : str1.toCharArray()) {
			count[ch-'a']++;
			
		}
		
		for(char ch : str2.toCharArray()) {
			int x=count[ch-'a']--;
			if(x<=0) {
				return false;
			}
			
		}
		return true;
		
		
	}

}
