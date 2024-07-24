package array;

public class SingleNumber {
	public static void main(String[] args) {
		int [] num = {4,1,2,1,2};
		int result =0;
		for(int i =0; i< num.length;i++) {
			result = result ^ num[i];
		}
		System.out.println(result);
	}

}


//[2,2,1] = 1
//[4,1,2,1,2] = 4

/*

0 ^ 4 =4
4 ^ 1 =5
5 ^ 2=7
7 ^ 1=6
6 ^ 2=4
*/