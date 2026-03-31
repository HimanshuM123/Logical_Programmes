package number;

public class TechNumber {
public static void main(String[] args) {
	
	int num =2025;//81
	String stringNum= String.valueOf(num);
	int length = stringNum.toCharArray().length;
	if(length %2==0) {
		int half = length/2;
		String firstPart = stringNum.substring(0,half);
		String secondPart = stringNum.substring(half,length);
		int res= Integer.parseInt(firstPart)+Integer.parseInt(secondPart);
		if(res*res==num) {
			System.out.println("The number is  tech number");
		}else {
			System.out.println("The number is NOT tech number");
		}
		
	}else {
		System.out.println("The number is NOT tech number");
	}
}
}


//2025 -> square(20+25)=2025