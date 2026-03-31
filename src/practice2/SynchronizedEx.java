package practice2;

class Table {
	synchronized void printTable(int n) {
		for (int i = 1; i <=5; i++) {
			System.out.println(i * n);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class SynchronizedEx {
	public static void main(String[] args) {
		Table obj = new Table();
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
