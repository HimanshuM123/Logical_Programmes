package number;


public class SunnyNumber {
public static void main(String[] args) {
	int num =80;

	boolean flag=false;

	Double g=  Math.sqrt(num+1);
	//System.out.println(g-Math.floor(g)); check if equals to 0
	String result= g.toString();
	int index =result.indexOf(".");
	if(result.charAt(index+1)=='0')
	{
		try {
			result.charAt(index+2);
		} catch (Exception e) {
			flag=true;
		}
	}
	
	if(flag) {
		System.out.println("The number is sunny");
	}else {
		System.out.println("The number is NOT sunny");
	}
	
}


}


// 80 -> 80+1 -> sqrt(81)=9