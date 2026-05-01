package number;

public class FinePrimeNumber {
public static void main(String[] args) {
boolean flag = false;
System.out.print("2 ");
	for(int num =3;num<=100;num++ ) {
		for (int i=2; i<num;i++) {
			if(num%i==0) {
				flag=false;
				break;
			}else {
				flag=true;
			}
		}
		if(flag) {
			System.out.print(num+" ");
		}
	}
}
}
