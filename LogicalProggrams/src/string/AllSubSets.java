package string;

public class AllSubSets {
public static void main(String[] args) {
	
	String str = "FUN";  
	int length=str.length();
	int count=0;
	String arr[]= new String[length*(length+1)/2];
	
	for(int i=0;i<=str.length()-1;i++) {
		for(int j=i;j<=str.length()-1;j++) {
			arr[count]=str.substring(i,j+1);
			count++;
		}
	}
	
	for(int i=0;i<=arr.length-1;i++) {
		System.out.println(arr[i]);
	}
	
}
}
/*

F
FU
FUN
U
UN
N


*/