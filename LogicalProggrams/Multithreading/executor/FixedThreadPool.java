package executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Work implements Runnable {

	private int id;

	public Work(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println("Task with Id " + id + " is in work-thread id: " + Thread.currentThread().getId());
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}

public class FixedThreadPool {

	public static void main(String[] args) {
		ExecutorService executer = Executors.newFixedThreadPool(2);
		// creates 2 threads to execute given task
		// reuses the threads

		for (int i = 0; i < 10; i++) {
			executer.execute(new Work(i + 1));
		}
		// prevent executor to execute further tasks
		executer.shutdown();

		// terminate actual running tasks
		try {
			if (!executer.awaitTermination(1000, TimeUnit.MILLISECONDS)) {
				executer.shutdownNow();//terminates immediately
			}

		} catch (InterruptedException e) {
			executer.shutdownNow();
		}
	}

}
