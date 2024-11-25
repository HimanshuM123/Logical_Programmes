package practice;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Practice2 {

	static int index = 1;
	static Object lock = new Object();

	public static void main(String[] args) {

		Thread t1 = new Thread(() -> {
			try {
				printSeq(0);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		Thread t2 = new Thread(() -> {
			try {
				printSeq(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	
		t1.start();
		t2.start();
		

	}

	private static void printSeq(int threadIndex) throws InterruptedException {
		while(index < 20) {
			synchronized (lock) {
				if(index %2==threadIndex) {
					System.out.println(index+"   "+Thread.currentThread());
					index++;
					lock.notifyAll();
				}else {
					lock.wait();
				}
				
			}
			
			
		}
		
		
		
		
		

	}
}
