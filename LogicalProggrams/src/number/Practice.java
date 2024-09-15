package number;

import java.util.HashMap;
import java.util.Map;

public class Practice {

	public static void main(String[] args) {
		
		for (int i = 0; i < 20; i++) {
			int res = fibo(i);
			System.out.println(res);
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