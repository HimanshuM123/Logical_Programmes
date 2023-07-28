package algorithmRecursion;

public class ReverseString {
public static void main(String[] args) {
	//String str= "ReverseMe";
	String str= "ReverseMe";
	String reverseString = reverse(str);
	System.out.println(reverseString);
}

private static String reverse(String str) {
	if(str.length()==0) {
		return "";
	}
	
	//                      everseMe               R
	//  					verseMe               eR
	//  					erseMe               veR
	String newString = reverse(str.substring(1))+str.charAt(0);
	
	return newString;
}
}
