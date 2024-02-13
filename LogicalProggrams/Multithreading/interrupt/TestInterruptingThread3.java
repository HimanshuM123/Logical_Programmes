package interrupt;

class TestInterruptingThread3 extends Thread {

	public void run() {
		for (int i = 1; i <= 5; i++)
			System.out.print(i+" ");
	}

	public static void main(String args[]) {
		TestInterruptingThread3 t1 = new TestInterruptingThread3();
		t1.start();

		t1.interrupt();

	}
}

//1 2 3 4 5 