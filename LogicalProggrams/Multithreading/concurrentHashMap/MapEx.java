package concurrentHashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapEx extends Thread {

	// Creating a static HashMap class object
	static HashMap<Integer, String> map = new HashMap<>();

	// run() method for the thread
	public void run() {

		// Try block to check for exceptions
		try {

			// Making thread to sleep for 3 seconds
			Thread.sleep(2000);
		}

		// Catch block to handle exceptions
		catch (InterruptedException e) {
		}

		// Display message
		System.out.println("Child Thread updating Map");

		// Putting element in map
		map.put(103, "C");
	}

	// Method 2
	// Main driver method
	public static void main(String arg[]) throws InterruptedException {

		// Adding elements to map object created above
		// using put() method
		map.put(101, "A");
		map.put(102, "B");

		// Creating thread inside main() method
		MapEx t = new MapEx();

		// Starting the thread
		t.start();

		for (Map.Entry<Integer, String> obj : map.entrySet()) {
			System.out
					.println("Main Thread Iterating Map and Current Entry is:" + obj.getKey() + "..." + obj.getValue());
			Thread.sleep(3000);
		}

		// Printing all elements on console
		System.out.println(map);
	}
}
