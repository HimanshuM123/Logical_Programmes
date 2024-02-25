package algorithmRecursion;

public class Factorial {
	public static void main(String[] args) {
		System.out.println(len("Himanshu"));
	}
	
	public  static int len(String str) {
		if(str.equals("")) {
			return 0;
		}
		
		return 1+ len(str.substring(1));
	}

}
