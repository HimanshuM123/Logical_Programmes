package myPkg;

// print 1 to 10 without using loop
public class Recursion1 {
	
	 static void printNum(int n){
		 if(n<=10) {
			 System.out.print(n+" ");
			 printNum(n+1);
		 }
		
	}
	
	public static void main(String[] args) {
		printNum(1);
	}

}
