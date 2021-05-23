package async;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureTest {
	public static void main(String[] args) {
		ExecutorService executorService=Executors.newFixedThreadPool(10);
		Future<Integer> future= executorService.submit(new Task());
		
		try {
			Integer result=future.get();
			System.out.println("Result is "+result);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}



class Task implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		Thread.sleep(10000);
		// TODO Auto-generated method stub
		return new Random().nextInt();
	}
	
	
	
}