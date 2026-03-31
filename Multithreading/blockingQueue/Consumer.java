package blockingQueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
	BlockingQueue queue = null;

	public Consumer(BlockingQueue queue) {
		super();
		this.queue = queue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				//Thread.sleep(100);
				System.out.println("Consumed " + queue.take());
			} catch (InterruptedException e) {
// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
