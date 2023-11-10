package stacksAndQueues;

import java.util.Arrays;
import java.util.Stack;

public class NGETR {
public static void main(String[] args) {
	int [] arr = {2, 5, 9, 3, 1, 12, 6,  8, 7};
	int [] result = new int[arr.length];
	Stack <Integer> st = new Stack<>();
		st.push(arr[arr.length-1]);
		result[arr.length-1]=-1;
	for(int i=arr.length-2;i>=0;i--) {
		while (st.size()>0 && arr[i]>= st.peek()) {
			st.pop();    //pop small elements
		}
		if(st.size()==0) {
			result[i]=-1;   //print
		}else {
			result[i]= st.peek();
		}
		st.push(arr[i]);   //push
	}
	System.out.println(Arrays.toString(result));
}
}

//Next greater element to the right
//[2 5 9  3  1  12 6  8  7]==>
//[5 9 12 12 12 -1 8 -1 -1]
/*
   		   |        
   		   |        
   		   |
   	|	   |
   	|	   |     |
   	|	   |     |  |
   	|	   |  |  |  |
  | |      |  |  |  |
  | |      |  |  |  |
  | |  |   |  |  |  |
| | |  |   |  |  |  |
| | |  | | |  |  |  |
2 5 9  3 1 12 6  8  7


*/