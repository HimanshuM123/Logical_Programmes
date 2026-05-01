package practice;

class Table {

	public  void printTable(int n) {
		for (int i = 1; i <= 5; i++) {
			System.out.println(n * i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class ThreadSync {

	public static void main(String[] args) {
		Table t = new Table();

		Thread t1 = new Thread(() -> {

			t.printTable(1);
		});

		Thread t2 = new Thread(() -> {

			t.printTable(10);
		});

		t1.start();
		t2.start();
	}

}
