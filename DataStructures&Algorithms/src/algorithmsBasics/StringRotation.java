package algorithmsBasics;

public class StringRotation {
	public static void main(String[] args) {
			String str1="abcdefg";
			String str2="defgacb";
			
			if((str1+str1).contains(str2)) {
				System.out.println("String are rotated");
			}
			else {
				System.out.println("String are not rotated");
			}
	}

}
