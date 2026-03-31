package pattern;

public class Pattern3 {
public static void main(String[] args) {
	for(int i=0;i<4;i++) {
		int k=0;
		for(int j=0;j<=4-i;j++) {
			if(j==4-i) {
				k++;
				System.out.print("*");
			}else {
				System.out.print(" ");
			}
			
		}
		while (i>=k) {
			System.out.print("*");
			k++;
		}
		
		System.out.println();
		
	}
}
}

/*
    *
   **
  ***
 ****
*****

*/
