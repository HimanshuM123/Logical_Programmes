package practice2;

public class MultiThreading3 extends Thread{
	
	public void run() {
		System.out.println("The thread is running....");
	}
	
	public static void main(String[] args) {
		MultiThreading3 m = new MultiThreading3();
		m.start();
	}

}
