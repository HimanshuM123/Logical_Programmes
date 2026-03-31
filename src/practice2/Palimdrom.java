package practice2;

public class Palimdrom {

	public static void main(String[] args) {
		 String  str ="madam";
		 boolean isPalimdrome = true;
		 
		 for(int i=0;i<str.length()/2;i++) {
			 if(str.charAt(i)!= str.charAt(str.length()-1-i)) {
				 isPalimdrome = false; 
			 }
		 }
		 
		 if(isPalimdrome) {
			 System.out.println("The String is Palimdrame");
		 }else {
			 System.out.println("The string is NOT palimdrome");
		 }
		 
		
	}
}
