package number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KeithNumber {
public static void main(String[] args) {
	
	int originalNumber = 742;
	int number=originalNumber;
	int numLen=0;
	List<Integer> al = new ArrayList<>();
	int rem=0;
	while(number >0) {
		rem = number %10;
		al.add(rem);
		number = number /10;
		numLen++;
	}
	Collections.reverse(al);
	int newNum=0;
	int lastNumber=0;
	while(lastNumber<originalNumber) {
	for(int i=0;i<numLen;i++) {
		newNum=newNum+al.get(al.size()-i-1);
	}
	al.add(newNum);
	lastNumber=newNum;
	newNum=0;
	
	}
	//System.out.println(al);

	if(lastNumber==originalNumber) {
		System.out.println("The number is Keith Number");
	}
	
}
}

//7, 4, 2, 13, 19, 34, 66, 119, 219, 404, 742=given number
