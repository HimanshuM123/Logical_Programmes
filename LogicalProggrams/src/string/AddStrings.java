package string;

public class AddStrings {
	public static void main(String[] args) {
		
		String result = addStrings("456","77");
		System.out.println(result);
	}
	
	
	private static String addStrings(String num1, String num2) {
		
		int i=num1.length()-1; int j=num2.length()-1;
		int c=0;
		StringBuilder sb = new StringBuilder();
		while(i>=0 || j >=0) {
			
			int a =i>=0? Integer.parseInt(num1.charAt(i)+""):0;
			int b =j>=0?Integer.parseInt(num2.charAt(j)+""):0;
			int sum = a+b+c;
			
			if(sum >9) {
				c=sum/10;
				sb.append(sum%10);
			}else {
				sb.append(sum);
				c=0;
			}
			
			i--;
			j--;
			
		}
		if(c!=0) {
		sb.append(c);
		}
	
		return sb.reverse().toString();
		
	}

}


/*

Input: num1 = "456", num2 = "77"
Output: "533"
*/