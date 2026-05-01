package threadTimeout;

class Test3 {
	public synchronized void m1() throws InterruptedException {
		{
			System.out.println("This is method 1");
			Thread.sleep(2000);

		}
	}

	public synchronized void m2() {
		{
			System.out.println("This is method 2");

		}
	}
}

public class ThreadTest {

	public static void main(String[] args) {
		Test3 test = new Test3();
		Runnable r1 = () -> {
			try {
				test.m1();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};

		Runnable r2 = () -> {

			test.m2();
		};

		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);

		t1.start();
		t2.start();
	}

}
