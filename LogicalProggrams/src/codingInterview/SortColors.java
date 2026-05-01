package codingInterview;

import java.util.Arrays;

public class SortColors {
	public static void main(String[] args) {
		int colors[] = { 0, 0, 2, 1, 1, 2 };

		int low = 0, mid = 0;
		int high = colors.length - 1;

		while (mid <= high) {
			if (colors[mid] == 0) {
				int temp = colors[low];
				colors[low] = colors[mid];
				colors[mid] = temp;
				low++;
				mid++;
				
			}else if (colors[mid] == 1) {
				mid++;
			}
			else {
				int tmp = colors[high];
				colors[high] = colors[mid];
				colors[mid] = tmp;
				high--;
				
			}

		}
		
		System.out.println(Arrays.toString(colors));//[0, 0, 1, 1, 2, 2]


	}
	


}
