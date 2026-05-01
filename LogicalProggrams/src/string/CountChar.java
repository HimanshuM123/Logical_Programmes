package string;

public class CountChar {
	public static void main(String[] args) {
		String sampleString ="The best of both worlds";
		int count=0;
		for(int i=0;i<=sampleString.length()-1;i++) {
			if(sampleString.charAt(i)!=' ') {
			count++;	
			}
		}
		System.out.println("The number of characters are: "+count);
	}

}
