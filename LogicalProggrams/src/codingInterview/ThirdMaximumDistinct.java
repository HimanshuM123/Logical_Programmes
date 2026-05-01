package codingInterview;

public class ThirdMaximumDistinct {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 5, 4, 3, 1 }; // 3

		int firstMax = Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;
		int thirdMax = Integer.MIN_VALUE;

		for (int obj : arr) {
			if (obj == firstMax || obj == secondMax || obj == thirdMax) {
				continue;
			}

			if (obj > firstMax) {
				thirdMax = secondMax;
				secondMax = firstMax;
				firstMax = obj;
			} else if (obj > secondMax) {
				thirdMax = secondMax;
				secondMax = obj;
			}  else if (obj > thirdMax) {
				thirdMax = obj;
			}

		}
		
		System.out.println(thirdMax);

	}

}
