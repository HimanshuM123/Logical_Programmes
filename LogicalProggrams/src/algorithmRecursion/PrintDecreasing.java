package algorithmRecursion;

public class PrintDecreasing {
	public static void main(String[] args) {
		printDcr(5);
	}
	
	private static void printDcr(int num) {
		if(num==0) return;
		System.out.println(num);
		printDcr(num-1);
	}
}
