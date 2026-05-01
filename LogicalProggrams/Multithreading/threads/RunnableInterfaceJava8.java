package threads;

public class RunnableInterfaceJava8 {
	public static void main(String[] args) {
		Runnable r = () -> {
			System.out.println("Thread is running using runnable...");
		};
		
		Thread t = new Thread(r);
		t.start();
	}
}
