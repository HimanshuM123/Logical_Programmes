package leetCodePepcoding;

//check all A's appears before all B's
public class CheckAllAs {
public static void main(String[] args) {
	String string = "aaaabbbb";
	int lastOccurenceA=0;
	int firstOccurenceB=0;
	
	for(int i=0;i<string.length();i++) {
		if(string.charAt(i)=='a') {
			lastOccurenceA=i;
		}
	}
	for(int i=0;i<string.length();i++) {
		if(string.charAt(i)=='b') {
			firstOccurenceB=i;
			break;
		}
	}
	System.out.println(lastOccurenceA);
	System.out.println(firstOccurenceB);
	
	if((lastOccurenceA)<firstOccurenceB) {
		System.out.println("true");
	}else {
		System.out.println("false");
	}
}
}

