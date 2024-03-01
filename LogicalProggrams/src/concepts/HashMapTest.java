package concepts;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
	public static void main(String[] args) {
		HashMap<StringBuffer, Integer> H = new HashMap<>();
		StringBuffer first = new StringBuffer("Aayush");
		StringBuffer second = new StringBuffer("Aayush");
		H.put(first, 1);
		H.put(second, 2);

		System.out.println(H);//{Aayush=2, Aayush=1}

		// Map<int , int> obj = new HashMap<>(); // Not allowed

	}

}
