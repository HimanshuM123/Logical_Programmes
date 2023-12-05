package synchronization;

public class SynchronizationExample3 {
	synchronized void printTable(int x) {
		for (int i = 1; i <= 5; i++) {
			System.out.println(i * x);
		}
	}

	public static void main(String[] args) {
		SynchronizationExample3 obj = new SynchronizationExample3();

		Thread t1 = new Thread(() -> {
			obj.printTable(1);
		});

		Thread t2 = new Thread(() -> {
			obj.printTable(10);
		});

		t1.start();
		t2.start();

	}

}
