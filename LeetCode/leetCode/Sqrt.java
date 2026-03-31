package leetCode;

public class Sqrt {
public static void main(String[] args) {
	int num =1;
	Sqrt sqrt = new Sqrt();
	int result = sqrt.mySqrt(num);
	System.out.println(result);
}

public int mySqrt(int x) {
	int result =0;
    for(double i=1;i<=x;i++) {
    	double y = x/i;
    	//System.out.println(y+" "+i);
    	if(y==i) {
    		result =(int) i;
    		break;
    	}
    	if(y<i) {
    		result =(int) i-1;
    		break;
    	}
    }
    return result;
}
}
