package practice;

public class Palimdrom {
public static void main(String[] args) {
	String string = "RGHHGR";
	boolean isPalimdrom= true;
	for(int i=0;i<string.length()/2;i++) {
		if(string.charAt(i)!=string.charAt(string.length()-i-1)) {
			isPalimdrom=false;
		}
	}
	if(isPalimdrom) {
		System.out.println("The string is palimdrom");
	}else {
		System.out.println("The string is NOT palimdrom");
	}
}
}
