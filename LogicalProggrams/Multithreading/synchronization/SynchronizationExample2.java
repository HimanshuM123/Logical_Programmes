package synchronization;

class Table2 {

	synchronized void printTable(int x) {
		for (int i = 1; i <= 5; i++) {
			System.out.println(i * x);
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}

	}

}

public class SynchronizationExample2 {

	public static void main(String[] args) {
		Table2 obj = new Table2();

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
