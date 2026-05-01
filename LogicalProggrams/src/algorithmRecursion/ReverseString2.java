package algorithmRecursion;

public class ReverseString2 {
public static void main(String[] args) {
	//String str= "ReverseMe";
	String str= "ReverseMe metoo";
	String reverseString ="";
	String [] arr =str.split(" ");
	for(String obj:arr) {
		reverseString=reverseString+ reverse(obj)+" ";
	}
	
	System.out.println(reverseString);
}

private static String reverse(String str) {
	if(str.length()==0) {
		return "";
	}
	String newString = reverse(str.substring(1))+str.charAt(0);
	
	return newString;
}
}
