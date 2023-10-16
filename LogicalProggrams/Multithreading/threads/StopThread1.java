package threads;

class StopTread implements Runnable {

	@Override
	public void run() {
		while (!Thread.interrupted()) {
			System.out.println("Thread is running ...");
		}
		System.out.println("Thread has stopped.");
	}

}

public class StopThread1 {

	public static void main(String[] args) {
		Thread t1 = new Thread(new StopTread());
		t1.start();
		try {
			Thread.sleep(3000);
			t1.interrupt();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
