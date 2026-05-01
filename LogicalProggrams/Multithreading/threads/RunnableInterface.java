package threads;

class MyRunnable implements Runnable {
	public void run() {
		System.out.println("Thread is running using runnable...");
	}

}

public class RunnableInterface {
	public static void main(String[] args) {
		Thread t = new Thread(new MyRunnable());
		t.start();
	}
}
