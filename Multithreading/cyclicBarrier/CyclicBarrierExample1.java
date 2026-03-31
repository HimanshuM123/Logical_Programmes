package cyclicBarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Worker implements Runnable {
	private int id;
	private Random random;
	private CyclicBarrier cyclicBarrier;

	public Worker(int id, CyclicBarrier cyclicBarrier) {
		this.id = id;
		this.cyclicBarrier = cyclicBarrier;
		this.random = new Random();
	}

	@Override
	public void run() {
		doWork();
	}

	public void doWork() {
		System.out.println("Thread with id " + id + " started the task");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Thread with id " + id + " finished the task");
		try {
			cyclicBarrier.await();
			System.out.println("After await....");
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String toString() {
		return "" + this.id;
	}
}

public class CyclicBarrierExample1 {
	public static void main(String[] args) {
		ExecutorService executors = Executors.newFixedThreadPool(5);

		CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {

			@Override
			public void run() {
				System.out.println("All threads are finished");

			}
		});
		for (int i = 0; i < 5; ++i) {
			executors.execute(new Worker(i + 1, cyclicBarrier));
		}
		executors.shutdown();

	}
}
