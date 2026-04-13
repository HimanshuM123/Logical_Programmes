package backtracking;

public class PrintNumber {
	public static void main(String[] args) {
		printNum(10);
	}
	
	private static void printNum(int num) {
		if(num==0) return;
		printNum(num-1);
		System.out.print(num+" ");
		
	}

}
