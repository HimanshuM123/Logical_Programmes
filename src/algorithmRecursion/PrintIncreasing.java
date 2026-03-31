package algorithmRecursion;

public class PrintIncreasing {
	public static void main(String[] args) {
		printIcr(5);
	}

	private static void printIcr(int num) {
		if(num==0) return ;
		printIcr(num - 1);
		System.out.println(num);

	}
}
