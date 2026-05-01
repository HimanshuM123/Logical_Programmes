package maang;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
	
	public static void main(String[] args) {
		int [] arr = {1,2,3,4,4,5};
		
		boolean res = hasDuplicates(arr);
		System.out.println(res);
	}
	
	
	private static boolean hasDuplicates(int [] arr) {
		
		Set<Integer> set = new HashSet<>();
		for(int obj : arr) {
			if(set.contains(obj)) {
				return true;
			}
			set.add(obj);
		}
		
		return false;
		
		
	}

}
