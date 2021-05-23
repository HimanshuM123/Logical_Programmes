package myPkg;


public class PrimeNumber2 {
	public static void main(String[] args) {
		int number=20;
		boolean flag=false;
		
		for (int i=2;i<number;i++) {
			for(int j=2;j<i;j++) {
				if(i%j==0) {
					flag=true;
					
				}
			}
			if(flag==false) {
				System.out.print(i+" ");
			}else {
				flag=false;
			}
			
		}
	}

}
