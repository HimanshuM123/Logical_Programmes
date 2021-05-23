package string;

public class ReverseWords {
	public static void main(String[] args) {
		String myString = "Java is secure";

		String[] words = myString.split(" ");

		String revString = "";
		String revWord = "";

		for (int i = 0; i < words.length; i++) {
			String word = words[i];

			for (int j = word.length() - 1; j >= 0; j--) {

				revWord = revWord + word.charAt(j);

			}
			revString = revString + revWord + " ";
			revWord = "";
		}

		System.out.println(revString);
	}

}
