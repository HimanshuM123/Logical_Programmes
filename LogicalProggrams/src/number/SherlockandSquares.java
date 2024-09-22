package number;

import java.util.ArrayList;
import java.util.List;

public class SherlockandSquares {
	public static void main(String[] args) {
		int a =24, b= 49;
		List<Integer> result = getSquares(a,b);
		System.out.println(result );
	}

	private static List<Integer> getSquares(int a, int b) {
		List<Integer> al = new ArrayList<>();
		for (int i = a; i <= b; i++) {
			if (isSquare(i)) {
				al.add(i);
			}
		}
		return al;

	}

	private static boolean isSquare(int num) {
		int root = (int) Math.sqrt(num);
		if (root * root == num) {
			return true;
		}
		return false;
	}

}

/*
 * a =24 , b = 49 25,36,49
 * 
 */