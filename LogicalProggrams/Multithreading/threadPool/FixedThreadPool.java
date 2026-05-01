package threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool {
	
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(5);
		executor.execute(new myThread());
	}

}

class myThread implements Runnable{

	@Override
	public void run() {
		System.out.println("The thread is running...");
		
	}
	
}
