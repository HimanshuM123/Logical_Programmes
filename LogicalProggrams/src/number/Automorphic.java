package number;

public class Automorphic {
public static void main(String[] args) {
	int num = 76;
	int square = num * num;
	boolean  isAutomorphic = true;
	
	while(num >0) {
		
		if(num %10 != square %10) {
			isAutomorphic = false;
		}
		
		num = num /10;
		square = square /10;
	}
	if(isAutomorphic) {
		System.out.println("Number is Automorphic ");
	}else {
		System.out.println("Number is NOT Automorphic ");
	}
	
}
}



// 25 -> 625
//76 -> 5776
//5 -> 25