package practice2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Practice2 {
	
	private synchronized void printTable(int t) {
		for(int i=1;i<=10;i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i*t);
		}
	}
	
	public static void main(String[] args) {
		Practice2 obj = new Practice2();
		
		Thread t1 = new Thread(()->{
			obj.printTable(1);
		});
		Thread t2 = new Thread(()->{
			obj.printTable(10);
		});
		
		t1.start();
		t2.start();
		
	}

}
