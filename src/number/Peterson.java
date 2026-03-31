package number;

public class Peterson {
public static void main(String[] args) {
	int originalNum =145;
	int result=0;
	int num =originalNum;
	
	while(num >0) {
		result= result + getFactorial(num%10);
		num = num /10;
	}
	if(result==originalNum) {
		System.out.println("The number is Peterson number");
	}else {
		System.out.println("The number is not a Peterson number");	
	}
	
}
static int getFactorial(int n) {
	int fact=1;
	for(int i=1; i<=n ; i++) {
		fact = fact *i;
	}
	return n==0?1:fact;
}

}

// 145 = 1! + 4! +5!
