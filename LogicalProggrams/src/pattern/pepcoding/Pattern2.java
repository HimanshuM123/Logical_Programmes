package pattern.pepcoding;

import java.util.Scanner;

public class Pattern2 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter number");
	int num = sc.nextInt();
	int star= num ;
	int space =0;
	
	for (int i=0;i<num;i++) {
		//System.out.println(star+" "+space);
		for(int k=0;k<space;k++) {
			System.out.print(" ");
		}
		for(int j=0;j<star;j++) {
			System.out.print("*");
		}
		
		star--;
		space++;
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