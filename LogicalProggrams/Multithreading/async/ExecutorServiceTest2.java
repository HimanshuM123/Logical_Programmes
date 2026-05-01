package async;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceTest2 {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		executorService.submit(new RunnableTask());
		//<T> Future<T> submit(Callable<T> task);
		// <T> Future<T> submit(Runnable task, T result);
		executorService.execute(new RunnableTask());//only Runnable task 
		executorService.shutdown();
	}

}

class RunnableTask implements Runnable {
	@Override
	public void run() {
		System.out.println("Inside Runnable task...");
	}
}