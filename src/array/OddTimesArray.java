package array;

import java.util.HashMap;
import java.util.Map;

//Find the number occurring odd number of times in an array
public class OddTimesArray {
	public static void main(String[] args) {
		int array[] = new int[]{20, 40, 50, 40, 50, 20, 30, 30, 50, 20, 40, 40, 20};
		
		Map<Integer,Integer> hm = new HashMap<>();
		for(int i=0;i<array.length;i++)
		{
			int element =array[i];
			if(!hm.containsKey(element)) {
				hm.put(element, 1);
			}else {
				hm.put(element, hm.get(element)+1);
			}
		}		

		
		for(Map.Entry<Integer, Integer> obj: hm.entrySet() ) {
			if(obj.getValue()%2!=0) {
				System.out.println(obj.getKey());
			}
		}
	}
}
