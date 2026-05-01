package map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MapExample {
	public static void main(String[] args) throws InterruptedException {

		Map<Integer, String> map =new HashMap<>();
		map.put(101, "A");
		map.put(102, "B");

		Thread t1 = new Thread(() -> {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Child Thread updating Map");

			map.put(103, "C");
		});
		t1.start();

		for (Map.Entry<Integer, String> obj : map.entrySet()) {
			System.out
					.println("Main Thread Iterating Map and Current Entry is:" + obj.getKey() + "..." + obj.getValue());
			Thread.sleep(3000);
		}

		System.out.println(map);

	
	}

}

/*

Main Thread Iterating Map and Current Entry is:101...A
Child Thread updating Map
Exception in thread "main" java.util.ConcurrentModificationException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1445)
	at java.util.HashMap$EntryIterator.next(HashMap.java:1479)
	at java.util.HashMap$EntryIterator.next(HashMap.java:1477)
	at map.MapExample.main(MapExample.java:27)

*/
