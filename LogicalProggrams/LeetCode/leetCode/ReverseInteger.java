package leetCode;

public class ReverseInteger {
public static void main(String[] args) {
	ReverseInteger rev = new ReverseInteger();
System.out.println(Integer.MAX_VALUE);
	int reversedNum= rev.reverse(1563847412);
	System.out.println("Output "+reversedNum);
}
public int reverse(int x) {
	if( x> Math.pow(2, 32) || x< -1 * Math.pow(2, 32)) {
		return 0;
	}
	boolean isNegetive= false;
	if(x<0) {
		isNegetive=true;
		x=-1 *x ;
	}
    int rev=0;
	while(x>0) {
		if( ((long)rev*10 + x%10> Math.pow(2, 32) ) || ( (long)(rev*10 + x%10)< 0)) {
			return 0;
		}
	rev= rev*10 + x%10;
	x=x/10;
	}
	return isNegetive ? -1 * rev: rev;
}
}

//2 000 000 000 
//9 000 000 00
//964632435