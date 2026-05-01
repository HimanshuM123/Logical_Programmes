package string;

public class DivideString {
	public static void main(String[] args) {

		String sampleString = "abcdefghijkl";
		int n = 4;
		String result = "";

		int part = sampleString.length() / n;

		for (int i = 0; i <= sampleString.length() - 1; i = i + part) {
			result = result + sampleString.substring(i, i + part) + " ,";

		}
		System.out.println(result);
	}
}
