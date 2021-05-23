package java8;

public class F_Runnable {
	public static void main(String[] args) {
		
		Runnable r =()-> {
			System.out.println("Thread is running");
		};
		
		new Thread(r).start();
		

	}
}
