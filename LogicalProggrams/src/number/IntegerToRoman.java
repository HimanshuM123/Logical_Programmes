package number;

public class IntegerToRoman {
public static void main(String[] args) {
	String result = convertIntToRoman(24);
	System.out.println("Result "+result);
}

private static String convertIntToRoman(int num) {
	
	int [] numArr = {100,90,50,40,10,9,5,4,1};
	
	String [] romanArr = {"C","XC","L","XL","X","IX","V","IV","I"};
	

	//24-> XXIV  10 10 4
	String romanNum ="";
	for(int i=0;i<numArr.length;i++) {
		while(num >= numArr[i]) {
			romanNum=romanNum+	romanArr[i];
			num = num -numArr[i];
		}
	}
	
	return romanNum;
}
}
