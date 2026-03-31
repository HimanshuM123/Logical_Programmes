package practice;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Phaser;

public class Practice2 {
	public static void main(String[] args) {
		Phaser p = new Phaser(1);
		
		for(int i=0; i<3;i++) {
			p.register();
			Thread t1 = new Thread(()->{
				System.out.println("phase1 execution  "+Thread.currentThread());
				p.arriveAndAwaitAdvance();
				System.out.println("phase2 execution  "+Thread.currentThread());
				p.arriveAndAwaitAdvance();
				
			});
			
			t1.start();
			
			
			
			
		}

		p.arriveAndAwaitAdvance();
		p.arriveAndAwaitAdvance();
		
	}
}
