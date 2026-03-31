package threads;

public class ThreadClassJava8 {
	public static void main(String[] args) {
		new Thread(() -> System.out.println("Thread is running")).start();
	}
}
