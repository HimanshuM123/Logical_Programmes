package concurrentHashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurMapEx2 extends Thread {

	// Creating a static HashMap class object
	static ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();

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
		ConcurMapEx2 t = new ConcurMapEx2();

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
