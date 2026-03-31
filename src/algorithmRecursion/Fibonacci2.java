package algorithmRecursion;

public class Fibonacci2 {

public static void main(String[] args) {
		
		for (int i = 0; i < 20; i++) {
			int res = fibo(i);
			System.out.print(res+" ");
		}

	}

	private static int fibo(int num) {
		if (num <= 1) {
			return 1;
		}

		return fibo(num - 1) + fibo(num - 2);

	}

}

// 1 1 2 3 5 8 13 21 34 55