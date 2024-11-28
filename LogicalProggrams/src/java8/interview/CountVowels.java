package java8.interview;

public class CountVowels {
	public static void main(String[] args) {
		String input = "Java 8 streams are powerful";

		long vowelCount = input.toLowerCase().chars()
		                       .filter(c -> "aeiou".indexOf(c) != -1)
		                       .count();

		System.out.println("Number of vowels: " + vowelCount);  // Output: 9
		
		long vowelCount2=
		input.chars().mapToObj(x -> (char)x).map(y -> y+"").filter(z -> "aeiou".contains(z)).count();
		
		System.out.println("Number of vowels: " + vowelCount2); 

	}

}
