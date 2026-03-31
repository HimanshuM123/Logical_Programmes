package number;

public class FascinatingNumber {
public static void main(String[] args) {
	boolean flag =true;
	int num =327;
	int num1 = num*2;
	int num2 = num*3;
	String finalResult=String.valueOf(num)+String.valueOf(num1)+String.valueOf(num2);

	System.out.println(finalResult);
	finalResult="322654981";
	int arr[]=new int[10];
	for(int i=0;i<finalResult.length();i++) {
		char r=finalResult.charAt(i);
		int position = Integer.parseInt(String.valueOf(r));
		arr[position]=position;
	}
	for(int i=1;i<10;i++) {
		if(arr[i]==0) {
			flag=false;
		}
	}
	if(flag) {
		System.out.println("The number is FascinatingNumber");
	}else {
		System.out.println("The number is NOT FascinatingNumber");
	}

}
}


//327×2=654
//
//327×3=981
//
//Now, concatenate the above results to the given number (n).
//
//"327"+"654"+ "981"= 327654981