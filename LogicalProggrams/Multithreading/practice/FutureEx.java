package practice;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureEx {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService ex = Executors.newFixedThreadPool(10);

		Future<Integer> f = ex.submit(new MyExecutor());
		System.out.println("Before future");
		Integer  i =f.get();
		System.out.println("After future "+i);
	}

}

class MyExecutor implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		Thread.sleep(2000);
		return (int) Math.random();
	}

}