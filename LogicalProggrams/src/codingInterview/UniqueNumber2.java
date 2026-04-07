package codingInterview;

public class UniqueNumber2 {
	
	public static void main(String[] args) {
		int [] arr = {1,3,5,3,2,1}; // 5 2
		printUnique2(arr);
		
	}
	
	
	private static void printUnique2(int [] nums) {
		int xorr=0;
		for(int num :nums) {
			xorr= xorr ^ num;
		}
		
		int setBit = xorr & (-xorr);
		int x=0; int y=0;
		
		for(int num :nums) {
			if ((num & setBit) != 0) {
				x = x^ num;
			}else {
				y = y^num;
			}
		}
		
		System.out.println("x-> "+x +"  y-> "+y);
		
		
		
	}

}
