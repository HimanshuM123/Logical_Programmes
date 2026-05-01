package interview;

public class EvenOdd {
	static int num = 0;
	static Object lock = new Object();

	public static void main(String[] args) {
		Thread t1 = new Thread(() -> printEvenOdd(0));
		Thread t2 = new Thread(() -> printEvenOdd(1));

		t1.start();
		t2.start();
	}

	private static void printEvenOdd(int threadIndex) {
		while (num < 20) {
			synchronized (lock) {
				if (num % 2 == threadIndex) {
					num++;
					System.out.println(Thread.currentThread() + " --> " + num);
					lock.notifyAll();
				} else {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
}
