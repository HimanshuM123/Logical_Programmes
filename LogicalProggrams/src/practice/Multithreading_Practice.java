package practice;

public class Multithreading_Practice {
	public static void main(String[] args) {
		
		Thread t1= new Thread(()-> System.out.println("thread started..."));
		t1.start();
	}

}
