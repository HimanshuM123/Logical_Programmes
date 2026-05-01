package number;

public class AutobiographicalNumber {
public static void main(String[] args) {
	//int num = 3211000;
	for(int i=1;i<1000000000;i++) {
		int num =i;
		int sum =0;
		int count =0;
		while(num>0) {
			count++;
			sum = sum+num%10;
			num =num/10;
		}
		if(count == sum) {
			System.out.println(i);
			
	}
	}
	
}
}


//3211000 -> 3+2+1+1=7 -> 3211000.length =7