package string;

public class Practice {
	public static void main(String[] args) {
		
		String str = "Hello World56   ";
		int j=str.length()-1;
		int count=0;
		
		while(str.charAt(j)==' ') {
			j--;
		}
		
		
		while(str.charAt(j)!=' ') {
			count++;
			j--;
		}
		System.out.println(count);
		
		
		
	}

}
