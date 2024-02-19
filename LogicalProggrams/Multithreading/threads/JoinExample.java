package threads;

class Runner1 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 10; ++i) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Runner1 " + i);
		}
	}

}

class Runner2 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 10; ++i) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Runner2 " + i);
		}
	}

}

public class JoinExample {
	public static void main(String[] args) {
			Thread t1=new Runner1();
			Thread t2=new Runner2();
			t1.start();
			
			try {
				t1.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			t2.start();
			
			System.out.println("Finished with thread");
	}
}
