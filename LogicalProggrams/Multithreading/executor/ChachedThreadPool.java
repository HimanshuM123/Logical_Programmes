package executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class ChachedThreadPool {

	public static void main(String[] args) {
		ExecutorService executer = Executors.newCachedThreadPool();

		for (int i = 0; i < 10; i++) {
			executer.execute(new Work(i + 1));
		}
		
		executer.shutdown();

		try {
			if (!executer.awaitTermination(1000, TimeUnit.MILLISECONDS)) {
				//Thread.sleep(10000);
				//executer.shutdownNow();//terminates immediately
			}

		} catch (InterruptedException e) {
			executer.shutdownNow();
		}
	}

}

