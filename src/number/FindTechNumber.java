package number;

public class FindTechNumber {
	public static void main(String[] args) {
		for(int num=0;num<=1000000;num++) {
		String stringNum= String.valueOf(num);
		int length = stringNum.toCharArray().length;
		if(length %2==0) {
			int half = length/2;
			String firstPart = stringNum.substring(0,half);
			String secondPart = stringNum.substring(half,length);
			int res= Integer.parseInt(firstPart)+Integer.parseInt(secondPart);
			if(res*res==num) {
				System.out.println("The  tech number is "+num);
			}else {
				//System.out.println("The number is NOT tech number");
			}
			
		}else {
			//System.out.println("The number is NOT tech number");
		}
	}
	}
}
