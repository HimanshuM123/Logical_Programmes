
package countdownlatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Worker implements Runnable {
	private int id;
	private CountDownLatch latch;

	Worker(int id, CountDownLatch countDownLatch) {
		this.id = id;
		this.latch = countDownLatch;
	}

	@Override
	public void run() {
		doWork();
		latch.countDown();//count down starts here

	}

	private void doWork() {
		System.out.println("Thread with id " + id + " starts working");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}

public class CountDownLatchExample2 {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		CountDownLatch latch = new CountDownLatch(5);
		for (int i = 0; i < 5; i++) {//task started
			executor.execute(new Worker(i + 1, latch));
		}

		try {
			latch.await();//waits until all countdown finishes
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("All the prerequisites are done...");
		executor.shutdown();

	}

}
