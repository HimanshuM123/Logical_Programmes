package synchronization;

class Table {

	synchronized void printTable(int n) {
		for (int i = 0; i < 5; i++) {
			System.out.println(n * i);

			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}

public class SynchronizationExample {
	public static void main(String[] args) {
		final Table table = new Table();

		Thread t1 = new Thread() {
			public void run() {

				table.printTable(1);
			}

		};

		Thread t2 = new Thread() {
			public void run() {

				table.printTable(10);
			}

		};
		t1.start();
		t2.start();
	}

}
