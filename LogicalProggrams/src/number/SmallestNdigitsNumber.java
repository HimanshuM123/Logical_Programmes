package number;

public class SmallestNdigitsNumber {
	public static void main(String[] args) {
		 int x = 2;
	        int y = 3;
	        int z = 5;
	        int n = 4;
	        System.out.println(smallestNDigitNumber(x, y, z, n)); // Output: 1020
	}
	  // Function to find the smallest n-digit number which is divisible by x, y, and z
    static int smallestNDigitNumber(int x, int y, int z, int n) {
        // Setting the lower and upper limits for n-digit numbers
        int lowerLimit = (int) Math.pow(10, n - 1);
        int upperLimit = (int) Math.pow(10, n) - 1;
 
        // Iterating through all n-digit numbers and checking if 
        // they are divisible by x, y, and z
        for (int number = lowerLimit; number <= upperLimit; number++) {
            if (isDivisibleByXYZ(number, x, y, z)) {
                return number;
            }
        }
 
        // If no n-digit number divisible by x, y, and z is found, return -1
        return -1;
    }
 
 // Function to check if a number is divisible by x, y, and z
    static boolean isDivisibleByXYZ(int number, int x, int y, int z) {
        return number % x == 0 && number % y == 0 && number % z == 0;
    }

}


/*

Smallest n digit number divisible by given three numbers

Input : x = 2, y = 3, z = 5
        n = 4
Output : 1020
Input : x = 3, y = 5, z = 7
        n = 2
Output : Not possible



*/