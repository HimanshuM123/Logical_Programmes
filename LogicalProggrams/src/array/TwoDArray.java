package array;

import java.util.HashMap;
import java.util.Map;

public class TwoDArray {
	public static void main(String[] args) {
		String[][] arr = { { "1", "Mango" }, { "2", "Apple" }, { "3", "Orange" }, { "4", "Grapes" } };

		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j <= arr[i].length; j++) {
			System.out.println(arr[i][j]);

			}
		}
		
		
	}
}
