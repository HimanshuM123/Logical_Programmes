package myPkg;

public class MaxTwo {
	public static void main(String[] args) {
		int num[] = { 5, 34, 78, 2, 45, 1, 99, 23 };
		int maxOne = 0;
		int maxTwo = 0;

		for (int obj : num) {
			if (obj > maxOne) {
				maxTwo = maxOne;
				maxOne = obj;

			} else if (obj > maxTwo) {
				maxTwo = obj;
			}
		}

		System.out.println(maxOne + " " + maxTwo);

	}

}
