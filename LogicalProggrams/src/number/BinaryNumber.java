package number;

public class BinaryNumber {
	
	public static void main(String[] args) {
		
		int num =6;
		String res =toBinary(num);
		System.out.println(res);
		
	}
	
	private static String toBinary(int num) {
		String result ="";
		while(num >0) {
			result = num%2+result;
			num = num /2;
		}
		return result;		
	}
	
//110
}

/*

6/2 =0
3/2=1
1/2=1


*/