package number;

import java.util.ArrayList;
import java.util.List;

public class MinimumNumberDivisible {

	public static void main(String[] args) {
		int number = 729;
		int result = getNum(number);
		System.out.println(result);

	}

	private static int getNum(int number) {
		int num = number;
		List<Integer> list = new ArrayList<>();

		while (num > 0) {
			
			list.add(num % 10);
			num = num / 10;
		}

		int num2 = number * 10;
		for (int i = num2; i < Integer.MAX_VALUE; i++) {
			int size = list.size();
			for (Integer obj : list) {
				if (num2 % obj == 0) {
					size--;
				}
				if (size == 0) {
					return i;
				}

			}
		}
		return 0;

	}

}
