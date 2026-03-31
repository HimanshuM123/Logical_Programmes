package array;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNums {
	public static void main(String[] args) {

		List<Integer> res = selfDevidingNumbers(1, 22);
		System.out.println(res);

	}

	private static List<Integer> selfDevidingNumbers(int left, int right) {
		List<Integer> list = new ArrayList<>();

		for (int i = left; i <= right; i++) {
			if (isSelfDivide(i)) {
				list.add(i);
			}
		}
		return list;

	}

	private static boolean isSelfDivide(int num) {

		for (char ch : String.valueOf(num).toCharArray()) {
			if (ch == '0' || num % (ch - '0') != 0) {
				return false;
			}
		}
		return true;
	}

}

/*
 * 128 -> 128%1=0 , 128%2=0, 128%8=0
 * 
 */