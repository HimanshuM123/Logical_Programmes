package pattern.pepcoding;

import java.util.Scanner;

public class Pattern1 {
	public static void main(String[] args) {
		System.out.println("Enter input number");
		Scanner sc =new Scanner(System.in);
		int n = sc.nextInt();
		int space = n-1;
		int star = 1;

		for(int i=0;i<n;i++) {
		//System.out.print(space +", "+star);
			for(int j=0;j<space;j++) {
				System.out.print("\t");
			}
			for(int k=0;k<star;k++) {
				System.out.print("*\t");
			}
			space--;
			star++;
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