package codingInterview;
//print FizzBuzz without using mod or div operator
public class FizzBuzz {
	public static void main(String[] args) {

		int i = 1;
		int c3 = 1;
		int c5 = 1;
		
		while (true) {
			if (c3 == 3 && c5 == 5) {
				System.out.println("FizzBuzz");
				break;
			} else if (c3 == 3) {
				System.out.println("Fizz");
				c3 = 0;
			} else if (c5== 5) {
				System.out.println("Buzz");
				c5 = 0;
			} else {
				System.out.println(i);
			}
			i++;
			c3++;
			c5++;

		}

	}

}
