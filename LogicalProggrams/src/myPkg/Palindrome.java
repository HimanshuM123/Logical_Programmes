package myPkg;

public class Palindrome {
public static void main(String[] args) {
	
	String sampleString="madams";
	boolean flag=true;
	
	for(int i=0;i<=sampleString.length()-1;i++) {
		if(sampleString.charAt(i)!=sampleString.charAt(sampleString.length()-1-i)) {
			flag=false;
			break;
		}
	}
	if(flag) {
		System.out.println("The string is palindrome");
	}else {
		System.out.println("The string is not palindrome");
	}
	
}
}
