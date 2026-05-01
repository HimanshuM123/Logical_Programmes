package myPkg;

public class Palindrome {
public static void main(String[] args) {
	
	String sampleString="madamr";
	boolean flag=true;
	
	for(int i=0;i<sampleString.length()/2;i++) {
		if(sampleString.charAt(i)!=sampleString.charAt(sampleString.length()-1-i)) {
			flag=false;
		}
	}
	if(flag) {
		System.out.println("String is Palimdom");
	}else {
		System.out.println("String is not Palimdrom");
	}
	
}
}
