package concepts;

import java.util.HashMap;
import java.util.Map;

public class MapMethods {
	public static void main(String[] args) {
		Map<Integer, String> hm = new HashMap<>();

		//return null or else previous values
		String val1 = hm.put(1, "Java");
		String val2 = hm.put(2, "c++");
		String val3 = hm.put(1, "Python");

		System.out.println(val1+" "+val2+" "+val3);//null null Java
		System.out.println(hm);//{1=Python, 2=c++}
	}

}
