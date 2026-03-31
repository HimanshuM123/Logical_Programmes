package map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SynchronizedMapExample2 {
	public static void main(String[] args) throws InterruptedException {
		

		Map<Integer, String> map = Collections.synchronizedMap(new HashMap<>());
		map.put(101, "A");
		map.put(102, "B");

		Thread t1 = new Thread(() -> {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Child Thread updating Map");

			map.put(103, "C");
		});
		t1.start();

		synchronized (map) { //explicitly synchronize the iteration
			for (Map.Entry<Integer, String> obj : map.entrySet()) {
				System.out
						.println("Main Thread Iterating Map and Current Entry is:" + obj.getKey() + "..." + obj.getValue());
				Thread.sleep(3000);
			}
		}
		

		System.out.println(map);
	
	}

}

/*
Main Thread Iterating Map and Current Entry is:101...A
Child Thread updating Map
Main Thread Iterating Map and Current Entry is:102...B
{101=A, 102=B, 103=C}

*/