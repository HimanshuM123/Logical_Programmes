package backtracking;

public class GenerateBinary {
	public static void main(String[] args) {
		generateBinary(3,"");
	}
	
	private static void generateBinary(int n, String str) {
		if(str.length()==n) {
			System.out.println(str);
			return;
		}
				
		generateBinary(n , str+"0");
		generateBinary(n , str+"1");
		
	}

}
