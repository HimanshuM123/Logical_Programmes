package algorithm;

public class RepeatedString {
public static void main(String[] args) {
	String sampleString ="abcac";
	int n=10;
	char [] arr=sampleString.toCharArray();
	String outputString ="";
	int j=0;
	int count=0;
	
	for(int i=0;i<n;i++) {
		
		if(j==arr.length) {
			j=0;
		}
		outputString=outputString+arr[j];
		if(arr[j]=='a') {
			count++;
		}
		j++;
	}
	System.out.println(outputString);
	System.out.println("occurence of a is "+count);
}
}


// abcac n=10  abcacabcac occurence of 'a'=4
// aba n=10 abaabaabaa , occurence of 'a'=7