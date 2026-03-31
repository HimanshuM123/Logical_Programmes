package threads;

public class JoinExample2 {
	public static void main(String[] args) throws InterruptedException {

		Thread t1 = new Thread(() -> {
			for(int i=1; i<=5;i++) {
				System.out.println(i);
			}
		});

		Thread t2 = new Thread(() -> {
			for(int i=1; i<=5;i++) {
				System.out.println(i*10);
			}
		});
		
		t1.start();
		t1.join();
		t2.start();

	}

}
