package string;

public class PermuteStringPractice {
	public static void main(String[] args) {
		String str = "ABC";
		generatePermutation(str, 0, str.length());

	}

	static void generatePermutation(String str, int start, int end) {
		if (start == end - 1) {
			System.out.println(str);
		} else {
			for (int i = start; i < end; i++) {
				str = swapString(str, start, i);
				generatePermutation(str, start + 1, end);
				str = swapString(str, start, i);
			}
		}
	}

	static String swapString(String str, int i, int j) {
		char[] a = str.toCharArray();
		char ch;
		ch = a[i];
		a[i] = a[j];
		a[j] = ch;
		return String.valueOf(a);
	}
}

//
//ABC
//ACB
//BAC
//BCA
//CBA
//CAB
