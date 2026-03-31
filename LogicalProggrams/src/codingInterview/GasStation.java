package codingInterview;

public class GasStation {
	public static void main(String[] args) {
		
		int [] gas  = {1, 2, 3, 4, 5};
		int [] cost = {3, 4, 5, 1, 2};
		
		int result = canCompleteCircuit(gas, cost);
		System.out.println(result ); //3
	}
	
	private static int canCompleteCircuit(int [] gas, int [] cost) {
		
		int totalTank=0;
		int currentTank=0;
		int startIndex=0;
		
		for(int i=0; i<gas.length; i++) {
			int diff = gas[i]-cost[i];
			totalTank = totalTank+diff;
			currentTank=currentTank+diff;
			
			if(currentTank <0) {
				startIndex= i+1;
				currentTank=0;
			}
		}
		 // If total gas is enough, return start index
        return totalTank >= 0 ? startIndex : -1;
	}
}


 


/*
You are given two arrays:

gas[i] → amount of gas at station i
cost[i] → gas needed to go from station i to i+1

You have a car with an empty tank at the start.

👉 Your goal:
Return the starting gas station index if you can travel around the circuit once in a clockwise direction. Otherwise, return -1.

gas  = [1, 2, 3, 4, 5]
cost = [3, 4, 5, 1, 2]

diff = [-2, -2, -2, +3, +3]

Start at index 0
i = 0
currentTank = 0 + (-2) = -2 ❌

Start at index 1
i = 1
currentTank = 0 + (-2) = -2 ❌

Start at index 2
i = 2
currentTank = 0 + (-2) = -2 ❌

Start at index 3

Now things change 👇

i = 3
currentTank = 0 + 3 = 3 ✅

i = 4
currentTank = 3 + 3 = 6 ✅

i = 0 (circular)
currentTank = 6 + (-2) = 4 ✅

i = 1
currentTank = 4 + (-2) = 2 ✅

i = 2
currentTank = 2 + (-2) = 0 ✅

🎉 We completed the full circle without going negative!

*/