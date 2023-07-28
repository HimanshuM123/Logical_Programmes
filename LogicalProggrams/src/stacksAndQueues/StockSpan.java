package stacksAndQueues;

import java.util.Arrays;
import java.util.Stack;

public class StockSpan {
public static void main(String[] args) {
	int [] arr= {2,5,9,3,1,12,6,8,7};
	int result []= new int[arr.length];
	Stack <Integer> st = new Stack<>();
	result[0]=1;
	st.push(1);
	int span=0;
	for(int i=1;i<arr.length;i++) {
		while(st.size()>0 && arr[i]>=arr[st.peek()]) {
			st.pop();
		}
		if(st.size()==0 ) {
			result[i]=i+1;
		}else {
			result[i]=i-st.peek();
		}
		st.push(i);
		System.out.println(Arrays.toString(result));
	}
}
}
