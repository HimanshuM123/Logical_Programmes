package codingInterview;

public class SingleLineSwap {
	public static void main(String[] args) {
		int a=10;
		int b=5;
		
		a=(a+b)-(b=a);
		System.out.println("a= "+a+" b="+b);
				
	}

}
