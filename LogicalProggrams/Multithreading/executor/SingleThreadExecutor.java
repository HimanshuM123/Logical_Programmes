package executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Task implements Runnable {

	private int id;

	public Task(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println("Task with Id " + id + " is in work-thread id: " + Thread.currentThread().getName());
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class SingleThreadExecutor {
	public static void main(String[] args) {
		// single thread will execute task sequentially one after another
		ExecutorService executer = Executors.newSingleThreadExecutor();

		for (int i = 0; i < 5; i++) {
			executer.execute(new Task(i));
		}
	}
}
