package pattern;

public class Pattern4 {
public static void main(String[] args) {
	for(int i=0;i<5;i++) {
		for(int j=0;j<=i;j++) {
			int k=i;
			int l=5-i;
			while(k>0) {
				System.out.print(" ");
				k--;
			}
			while(l>0) {
				System.out.print("*");
				l--;
				
			}
			if(l==0) {
				j=i;
			}
			
		
		}
		System.out.println();
	}
}
}


/*
*****
 ****
  ***
   **
    *

*/