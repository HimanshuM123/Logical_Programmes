package printSequence;

public class PrintSeq {
	int counter = 1;
	int n = 10;

	public static void main(String[] args) {

		PrintSeq seq = new PrintSeq();

		Thread t1 = new Thread(() -> {
			seq.printEven();
		});

		Thread t2 = new Thread(() -> {
			seq.printOdd();
		});

		t1.start();
		t2.start();

	}

	private void printOdd() {
		synchronized (this) {
			while (counter < n) {
				while (counter % 2 == 0) {
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO: handle exception
					}
				}
				System.out.print(counter + " ");

				// Increment counter
				counter++;

				// Notify to second thread
				notify();
			}
		}
	}
	
	private void printEven() {
		synchronized (this) {
			while (counter < n) {
				while (counter % 2 != 0) {
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO: handle exception
					}
				}
				System.out.print(counter + " ");

				// Increment counter
				counter++;

				// Notify to second thread
				notify();
			}
		}
	}

}
