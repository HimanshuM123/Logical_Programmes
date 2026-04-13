package backtracking;

public class SubsetString {
	public static void main(String[] args) {
		subset("ab",0,"");
	}
	
	private static void subset(String s , int index, String current) {
		if(index == s.length()) {
			System.out.println(current);
			return;
		}
		
		//exclude
		subset(s,index+1,current);
		
		//include
		subset(s,index+1,current+s.charAt(index));
		
		
		
	}

}
