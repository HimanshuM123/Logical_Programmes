package threads;

import java.util.concurrent.atomic.AtomicBoolean;

class StopTreadFlag implements Runnable {

	private final AtomicBoolean running = new AtomicBoolean(false);

	@Override
	public void run() {
		running.set(true);
		while (running.get()) {
			System.out.println("Thread is running ...");
		}
		System.out.println("Thread has stopped.");
	}

	public void stop() {
		System.out.println("Inside stop");
		running.set(false);
	}

}

public class StopThread2 {
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new StopTreadFlag());
		StopTreadFlag s = new StopTreadFlag();
		t1.start();
		// Thread.sleep(2000);
		s.stop();
	}

}
