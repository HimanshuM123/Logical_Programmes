package java8;

public class LamdaThread {

	public static void main(String[] args) {

		Runnable r1 = () -> {
			System.out.println("Thread1 running...");
		};

		Thread t1 = new Thread(r1);

		Runnable r2 = () -> {
			System.out.println("Thread2 running...");
		};

		Thread t2 = new Thread(r2);

		t1.start();
		t2.start();

	}

}
