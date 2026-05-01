package codingInterview;

public class MaximumKWindowAvg {
    
    public static void main(String[] args) {
        int[] arr = {1, 12, -5, -6, 50, 3};//12.75 -->(12, -5, -6, 50)/4
        int k = 4;
        
        double result = avg(arr, k);
        System.out.println(result);
    }
    
    // sliding window approach
    private static double avg(int[] arr, int k) {
        
        double maxAvg = Double.NEGATIVE_INFINITY;
        int i = 0, j = 0;
        int sum = 0;
        
        while (j < arr.length) {
            sum =sum+ arr[j];
            
            if (j - i + 1 < k) {
                j++;
            } else {
                maxAvg = Math.max(maxAvg, (double) sum / k); 
                sum = sum -arr[i];
                i++;
                j++;
            }
        }
        
        return maxAvg;
    }
}

/*

Time Complexity = O(n)
Space Complexity=O(1)


*/