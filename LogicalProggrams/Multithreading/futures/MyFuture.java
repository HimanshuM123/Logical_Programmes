package futures;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyFuture {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService es = Executors.newSingleThreadExecutor();
		Future<String> future = es.submit(()->{
			Thread.sleep(2000);
			return "Welcome to JavaTpoint";
		});
		
//		while(!future.isDone()) {
//			System.out.println("Task is in progress");
//			Thread.sleep(200);
//		}
		System.out.println("Task completed ! getting the result");
		System.out.println("Main thread waiting here ...");
		String result = future.get();
		System.out.println("Result -> "+result);
		es.shutdown();
	}

}
