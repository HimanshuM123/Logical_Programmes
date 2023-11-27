package volatiletest;



public class VolatileTest {
	  boolean flag = true;

	private void test(boolean flag1) {
		this.flag = flag1;
		while (flag) {
			System.out.println("running loop...");
		}
	}

	public static void main(String[] args) {
		VolatileTest obj = new VolatileTest();
		Thread t1 = new Thread(() -> {
			System.out.println("Thread 1 started");
			obj.test(true);
		});

		Thread t2 = new Thread(() -> {
			System.out.println("Thread 2 started");
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			obj.test(false);
		});

		t1.start();
		t2.start();

	}
}
