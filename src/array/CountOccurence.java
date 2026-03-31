package array;

import java.util.HashMap;
import java.util.Map;

public class CountOccurence {
public static void main(String[] args) {
	int [] arr= {5,3,6,5,1,2,2,2,6,8};
	Map<Integer,Integer> hm = new HashMap<>();
	for(int i=0;i<arr.length;i++) {
		//if(hm.containsKey(arr[i])) {
		if(hm.get(arr[i])!=null) {
		hm.put(arr[i], hm.get(arr[i])+1);
		}else {
			hm.put(arr[i], 1);
		}
	}
	System.out.println(hm);
}
}


//5->1, 3->1, 2->3....