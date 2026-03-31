package string;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ReverseWords1 {
public static void main(String[] args) {
	String sampleString ="Java is Secure";
	String result ="";
	
	String [] arr = sampleString.split(" ");
	
	for(int i=0; i<arr.length;i++) {
		String word = arr[i];
		String rev="";
		for(int j=word.length()-1;j>=0;j--) {
			rev= rev+word.charAt(j);
		}
		result = result +rev+" ";
	}
	
	System.out.println(result);
}
}
