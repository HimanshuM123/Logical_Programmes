package string;

public class PermuteStringPractice {
	public static void main(String[] args) {
		String str = "ABC";
		generatePermutation(str, "");

	}

	static void generatePermutation(String str, String asf) {
		if(str.length()==0) {
			System.out.println(asf);
		}
		
		for(int i=0; i<str.length();i++) {
			
			char ch = str.charAt(i);
			String left = str.substring(0,i);
			String right = str.substring(i+1);
			String result = left +right;
			generatePermutation(result,asf+ch);
		}
	
		
	}
}

//
//ABC
//ACB
//BAC
//BCA
//CBA
//CAB
