package concurrentHashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapEx1 {

	public static void main(String arg[]) throws InterruptedException {
		HashMap<Integer, String> map = new HashMap<>();

		map.put(101, "A");
		map.put(102, "B");
//User Thread
		Thread thread = new Thread(() -> {

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Child Thread updating Map");

			map.put(103, "C");

		});
		thread.start();
//main Thread
		for (Map.Entry<Integer, String> obj : map.entrySet()) {
			System.out
					.println("Main Thread Iterating Map and Current Entry is:" + obj.getKey() + "..." + obj.getValue());
			Thread.sleep(3000);
		}

		System.out.println(map);
	}
}
