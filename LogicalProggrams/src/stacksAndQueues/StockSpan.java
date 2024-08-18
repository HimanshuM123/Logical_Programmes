package stacksAndQueues;

import java.util.Arrays;
import java.util.Stack;

public class StockSpan {
public static void main(String[] args) {
	int [] arr= {2,5,9,3,1,12,6,8,7};
	int result []= new int[arr.length];
	Stack <Integer> stk = new Stack<>();
	result[0]=1;
	stk.push(1);
	
	for(int i=1;i<arr.length;i++) {
		while(!stk.isEmpty() && arr[i]>=arr[stk.peek()]) {
			stk.pop();
		}
		if(stk.size()==0 ) {
			result[i]=i+1;
		}else {
			result[i]=i-stk.peek();
		}
		stk.push(i);
		
	}
	
	System.out.println(Arrays.toString(result));
}
}

//{2,5,9,3,1,12,6,8,7}; 2->2, 5-> 2,5, 9-> 2,5,9 , ...
//[1, 2, 3, 1, 1, 6, 1, 2, 1]
/*
 
 Design an algorithm that collects daily price quotes for some stock and returns the span of that stock's price for the current day.

The span of the stock's price in one day is the maximum number of consecutive days (starting from that day and going backward) 
for which the stock price was less than or equal to the price of that day.

For example, if the prices of the stock in the last four days is [7,2,1,2] and the price of the stock today is 2, then the span of today is
 4 because starting from today, the price of the stock was less than or equal 2 for 4 consecutive days.
Also, if the prices of the stock in the last four days is [7,34,1,2] and the price of the stock today is 8, then the span of today is 
3 because starting from today, the price of the stock was less than or equal 8 for 3 consecutive days.
 
 */
