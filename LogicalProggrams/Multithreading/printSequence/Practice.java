package printSequence;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Practice {
	static String str = "abcdefghijklmnop";
	static Object lock = new Object();
	static int index = 0;

	public static void main(String[] args) {

		Thread t1 = new Thread(() -> {
			try {
				printChars(0);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		Thread t2 = new Thread(() -> {
			try {
				printChars(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		Thread t3 = new Thread(() -> {
			try {
				printChars(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		t1.start();
		t2.start();
		t3.start();

	}

	private static void printChars(int threadIndex) throws InterruptedException {
		while (index < str.length()) {
			synchronized (lock) {
				if(threadIndex==index%3) {
					System.out.println(str.charAt(index)+" "+Thread.currentThread());
					lock.notifyAll();
					index++;
				}else {
					lock.wait();
				}
			}
			

		}

	}

}
