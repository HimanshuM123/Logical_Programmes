package threads;

import synchronization.SynchronizationLock;

public class SynchronizationCustomLock {

	public static int counter1 = 0;
	public static int counter2= 0;
	
	//custom object lock
	private static final Object lock1=new Object();
	private static final Object lock2=new Object();

	
	//here thread can access both method independently..since they are not using intrinsic lock
	//both thread execute without waiting for others
	public static  void increment1() {
		synchronized(lock1) {
		counter1++;
		}
	}
	public static  void increment2() {
		synchronized(lock2) {
		counter2++;
		}
	}

	public static void process() {
		Thread t1 = new Thread() {
			public void run() {
				for (int i = 0; i < 100; i++) {
					increment1();
				}
			}

		};

		Thread t2 = new Thread() {
			public void run() {
				for (int i = 0; i < 100; i++) {
					increment2();
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

		System.out.println("Counter value is " + counter1);
		System.out.println("Counter value is " + counter2);
	}

	public static void main(String[] args) {
		process();
	}

}
