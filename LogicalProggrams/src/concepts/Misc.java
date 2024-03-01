package concepts;

public class Misc {
	public static void main(String[] args) {
		Double a = 12.3456;
		Double b = 12.3456;
		
		System.out.println(a == b);// false
		System.out.println(a.equals(b));// true

		double c = 12.3456;
		double d = 12.3456;
	
		System.out.println(c == d);// true
	}

}
