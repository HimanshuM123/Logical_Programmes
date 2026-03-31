package array;

import java.util.HashSet;
import java.util.Set;

public class FirstRepeatingNum {
	public static void main(String[] args) {
		int array[] = { 10, 7, 8, 1, 8, 7, 6 };
		int min = getFirstRepeatingElementArray(array);
		if (min == -1) {
			System.out.println("No element found");
		} else {
			System.out.println("The first repeating element is " + min);
		}
	}

	private static int getFirstRepeatingElementArray(int[] arr) {

		Set<Integer> set = new HashSet<>();
		int element = -1;

//		for (int i = arr.length - 1; i > 0; i--) {
//			if (set.contains(arr[i])) {
//				element = arr[i];
//			} else {
//				set.add(arr[i]);
//			}
//		}
		
		for(int i=0; i< arr.length;i++) {
			if(set.contains(arr[i])) {
				return arr[i];
			}else {
				set.add(arr[i]);
			}
		}
		return element;
	}
}
