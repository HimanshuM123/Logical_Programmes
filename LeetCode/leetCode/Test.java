package leetCode;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Test {
public static void main(String[] args) {
	long num =987654321;
	long product = num*10;
	Long l = new Long(product);
	System.out.println(l);
	System.out.println(l.intValue());
	
	
	BigDecimal  sum =new BigDecimal (12);
	
	int flag = sum.compareTo(new BigDecimal (0));
	System.out.println("flag  "+flag);
	
	BigDecimal res = sum.remainder(new BigDecimal (10));
	System.out.println(res);
}
}
