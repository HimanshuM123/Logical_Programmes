package string;



import java.util.HashSet;
import java.util.Set;

public class Pangrams {

	public static void main(String[] args) {
		String str = "AbcdefghijklmnopqrstuvwxyzA";
		boolean flag = isPangram(str);
		
		if(flag) {
			System.out.println("The String is Pangram");
		}else {
			System.out.println("The String is NOT Pangram");
		}
	}

	private static boolean isPangram(String str) {
		String str1 = str.toLowerCase();
		Set<Character> set = new HashSet<>();
		for (Character ch : str1.toCharArray()) {
			set.add(ch);
		}
		
		if(set.size()==26) {
			return true;
		}else {
			return false;
		}
		
	}

}

//The String is Pangram
