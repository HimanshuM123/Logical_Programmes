package codingInterview;

public class MajorityElement {

	public static void main(String[] args) {
		int[] arr = { 7, 7, 5, 7, 5, 1, 2, 7, 7 };

		int result = majorityEle(arr);
		System.out.println(result);

	}

	private static int majorityEle(int[] arr) {
		int n = arr.length;
		int candidate = arr[0];
		int vote = 1;
		for (int i = 1; i < n; i++) {
			if (vote == 0) {                //step2
				candidate = arr[i];
				vote = 1;
			} else if (candidate == arr[i]) { //step1
				vote++;
			} else {
				vote--;
			}
		}
		return candidate;
	}

}
/*
candidate=7 ,vote=1, i=0    7
candidate=7 ,vote=2, i=1    7
candidate=7 ,vote=1, i=2    5
candidate=7 ,vote=2, i=3    7
candidate=7 ,vote=1, i=4    5
candidate=7 ,vote=0, i=5    1
candidate=2 ,vote=1, i=6    2
candidate=2 ,vote=0, i=7    7
candidate=7 ,vote=1, i=8    7 <--





*/