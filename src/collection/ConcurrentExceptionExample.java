package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ConcurrentExceptionExample {
	public static void main(String args[]) throws Exception {

	//	Map<String, Integer> map = new HashMap<>();
		 Map<String, Integer> map = new ConcurrentHashMap<>();
		ExecutorService executor = Executors.newFixedThreadPool(5);

		try {

			// create a task to write to the map a little faster than the reader
			Runnable writer = () -> {
				for (int i = 0; i < 100; i++) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException ie) {
						/* ignore */ }
					map.put("key-" + i, i);
				}
			};

			// create a task that slowly reads from the map.
			Runnable reader = () -> {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ie) {
					/* ignore */ }

				for (Map.Entry<String, Integer> entry : map.entrySet()) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException ie) {
						/* ignore */ }
					System.out.println("key " + entry.getKey() + " value " + entry.getValue());
				}
			};

			// submit the task twice
			Future<?> future1 = executor.submit(writer);
			Future<?> future2 = executor.submit(reader);

			// wait for the threads to finish
			future1.get();
			future2.get();
		} finally {
			// We know the code will generate a ConcurrentModificationException so
			// remember to shutdown the executor service in a finally block
			executor.shutdown();
		}

	}
}
