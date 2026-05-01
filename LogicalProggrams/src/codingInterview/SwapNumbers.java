package codingInterview;

//swap numbers without using 3rd variable
public class SwapNumbers {

	public static void main(String[] args) {

		int a = 5;
		int b = 10;
		
		a=a^b; //5^10
		b=a^b; //5^10^10 =5
		a=a^b ; //5^10 ^5=10
		
		System.out.println("a ->"+a+ " b->"+b);

	}

}


/*

 		int a = 5;
        int b = 10;

        a = a + b; // a = 15
        b = a - b; // b = 15 - 10 = 5
        a = a - b; // a = 15 - 5 = 10

        System.out.println("a -> " + a + " b -> " + b);



*/