package synchronization;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantlockEx extends Thread {

	private final ReentrantLock lock = new ReentrantLock();

	private int seats = 100;

	@Override
	public void run() {
		while (seats != 0) {
			lock.lock();
			try {
				if (seats > 0) {
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					seats--;
					System.out.println(
							Thread.currentThread().getName() + " booked the seats , the seats left = " + seats);
				}

			} finally {
				lock.unlock();

			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		ReentrantlockEx obj = new ReentrantlockEx();
		Thread t1 = new Thread(obj, "station1");
		Thread t2 = new Thread(obj, "station2");
		t1.start();
		t2.start();
		t1.join();
		t2.join();
	}

}
