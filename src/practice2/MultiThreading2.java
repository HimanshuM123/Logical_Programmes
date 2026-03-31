package practice2;

public class MultiThreading2 {
	public static void main(String[] args) {
		Runnable r = ()->{
			
			System.out.println("Thread is running inside runable...");
		};
		
		Thread t =new Thread(r);
		t.start();
		
	}
}
