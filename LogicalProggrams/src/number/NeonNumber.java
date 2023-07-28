package number;

public class NeonNumber {
public static void main(String[] args) {
	int number= 45;
	int originalNum=number;
	int num1=0;
	int sum=0;
	while(number>0) {
		sum=sum+number%10;
		number=number/10;
	}
	System.out.println(sum);
	int sum2=0;
	int square =originalNum*originalNum;
	while(square >0) {
		sum2=sum2+square%10;
		square=square/10;
	}
	if(sum==sum2) {
		System.out.println("The number Neon Number");
	}else {
		System.out.println("The number NOT Neon Number");
	}
	
}
}

//(45)2 = 2025=> 2+0+2+5=9
