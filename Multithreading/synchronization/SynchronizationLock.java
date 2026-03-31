package synchronization;

public class SynchronizationLock {

	public static int counter = 0;

	public static  void increment() {
		//intrinsic lock (eg.synchronized)
		synchronized(SynchronizationLock.class) {//class level locking for static method
			//synchronized(this) {//object level locking
		counter++;
		}
	}

	public static void process() {
		Thread t1 = new Thread() {
			public void run() {
				for (int i = 0; i < 100; i++) {
					increment();
				}
			}

		};

		Thread t2 = new Thread() {
			public void run() {
				for (int i = 0; i < 100; i++) {
					increment();
				}
			}

		};
		t1.start();
		t2.start();
		
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Counter value is " + counter);
	}

	public static void main(String[] args) {
		process();
	}

}
