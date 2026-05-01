package leetcode2;

public class ToLowerCase {
	public static void main(String[] args) {
		String str = "acDSadDRR";
		String result ="";
		for(int i=0;i<str.length();i++) {
			if(Character.isUpperCase(str.charAt(i))) {
				result = result + (char)((str.charAt(i))+32);
			}
			else {
				result = result +(str.charAt(i));
			}
		}
		System.out.println(result);
	}
}
