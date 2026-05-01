package number;

public class SpyNumber {
public static void main(String[] args) {
	int num= 1124;
	int sum=0;
	int product=1;
	int num1=num;
	while(num1>0) {
		sum=sum+num1%10;
		num1=num1/10;
	}
	int num2=num;
	while(num2>0) {
		product=product*num2%10;
		num2=num2/10;
	}
	
	if(sum==product) {
		System.out.println("The number is SpyNumber");
	}else{
		System.out.println("The number is NOT SpyNumber");
	}
}
}
