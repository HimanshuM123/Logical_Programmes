package practice;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class Practice {

	public static void main(String[] args) {

		BlockingQueue<Integer> bq = new ArrayBlockingQueue<>(5);

		Thread producer = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(100);
					System.out.println("Putting..."+i);
					bq.put(i);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		Thread consumer = new Thread(() -> {
			while (true) {
				try {
					Thread.sleep(200);
					System.out.println("Getting..."+bq.take());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		producer.start();
		consumer.start();
	}

}
