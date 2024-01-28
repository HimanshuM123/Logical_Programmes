package java8;

public class F_Runnable {
	public static void main(String[] args) {

		Runnable r = () -> {
			System.out.println("Thread is running");
		};

		new Thread(r).start();

		Thread t2 = new Thread(() -> {
			System.out.println("Second thread is running...");
		});

		t2.start();

	}
}
