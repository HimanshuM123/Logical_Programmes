package string;

public class Anagram {
	
	public static void main(String[] args) {
		String str1="braggg";
		StringBuffer str2=new StringBuffer("gggrab");
		
		if(isAnagram(str1,str2)) {
			System.out.println("The string is Anagram");	
		}
		else {
			System.out.println("The string is not Anagram");
		}
		
		
	}
	
	 static boolean isAnagram(String str1,StringBuffer str2) {
		for(int i=0;i<=str1.length()-1;i++) {
			int index=str2.indexOf(""+str1.charAt(i));
			if(index!=-1) {
				str2.deleteCharAt(index);
			}
		}
		return str2.length()==0;
		}

}
