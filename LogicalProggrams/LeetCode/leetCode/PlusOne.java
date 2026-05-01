package leetCode;

import java.math.BigDecimal;
import java.util.Arrays;

public class PlusOne {
public static void main(String[] args) {
//	int [] arr = {4,3,2,1};
//	int [] arr = {9};
//	int [] arr = {9,8,7,6,5,4,3,2,1,0};
	int [] arr = {7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,6};
	PlusOne p = new PlusOne();
	System.out.println(Arrays.toString(p.plusOne(arr)));
	
}

public int[] plusOne(int[] digits) {
	BigDecimal  sum =new BigDecimal (0);
	 BigDecimal ten = new BigDecimal(10);
    int index =0;
    int count=0;
    
    for (int i=0;i<digits.length;i++) {
    	sum = sum.multiply(ten).add(new BigDecimal(digits[i])) ;
    	 System.out.println(sum);
    }
   
   sum = sum.add(new BigDecimal(1));
   count = String.valueOf(sum).toCharArray().length;
   int [] result = new int[count];
  
    while(sum.compareTo(new BigDecimal (0))==1) {
    	BigDecimal num = sum.remainder((new BigDecimal (10)));
    	result[count-1-index]=num.intValue();
    	sum=sum.divideToIntegralValue(new BigDecimal(10));
    	index ++;
    }
    return result;
}
}



//Input: digits = [4,3,2,1]
//Output: [4,3,2,2]
//Explanation: The array represents the integer 4321.
//Incrementing by one gives 4321 + 1 = 4322.
//Thus, the result should be [4,3,2,2].