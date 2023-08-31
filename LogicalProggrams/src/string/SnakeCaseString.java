package string;


public class SnakeCaseString {
public static void main(String[] args) {
	
	String str = "whatIsYourName";
	
	String result="";
	
	for(Character obj: str.toCharArray()) {
		if(Character.isUpperCase(obj)) {
			result=result+"_"+obj;
		}else {
			result=result+obj;
		}
	}
	
	System.out.println(result.toUpperCase());
	
	
}
}



//whatIsYourName -> WHAT_IS_YOUR_NAME