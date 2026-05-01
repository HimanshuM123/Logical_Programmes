package concepts;

public class IntTest {
	public static void main(String[] args) {
		int i = 9;
		int j = 07;
	//	int k = 09; // compilation error --The literal 09 of type int is out of range 
		
		System.out.println("i "+i +" j "+j);
		
	}

}

//i 9 j 7

/*


0n is parsed as a number in octal base.

08 and 09 do not exist in octal base, since the only valid digits in that base are 0 to 7.

*/