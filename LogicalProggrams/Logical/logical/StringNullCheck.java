package logical;

public class StringNullCheck {
	
	public static void main(String[] args) {
		
		String nullString =null;
		
		/*if(nullString!=null && nullString.equals("something")) {
			System.out.println("its null string");
		}*/
		
		if("something".equals(nullString)) {
			System.out.println("its null string");
		}
		
		
		/*if(nullString.equals("something")) {
			System.out.println("its null string");
		}*/
		
		
	}

}
