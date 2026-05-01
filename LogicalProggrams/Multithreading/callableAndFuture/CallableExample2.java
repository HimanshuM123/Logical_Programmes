package callableAndFuture;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample2 {
	public static void main(String[] args) {

		Callable<Integer> task = () -> 2 * 2;

		ExecutorService ex = Executors.newSingleThreadExecutor();

		Future<Integer> future = ex.submit(task);
		try {
			Integer result = future.get();
			System.out.println(result);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
