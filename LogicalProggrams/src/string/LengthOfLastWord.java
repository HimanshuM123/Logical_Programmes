package string;

public class LengthOfLastWord {

	public static void main(String[] args) {
		String str = "Hello World   ";

		int counter = 0;
		int i = str.length() - 1;
		while (str.charAt(i) == ' ') {
			i--;
		}

		while (str.charAt(i) != ' ') {
			counter++;
			i--;
		}

		System.out.println("The length of last word is ->" + counter);
	}

}
