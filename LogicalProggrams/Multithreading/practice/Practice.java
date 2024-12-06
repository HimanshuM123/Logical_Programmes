package practice;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class Practice {
	//static Integer count =0;
	static AtomicInteger count = new AtomicInteger(1);
	public static void main(String[] args) {

		
		ExecutorService ex = Executors.newFixedThreadPool(10);
		
		
		for(int i=0 ;i<10;i++) {
			ex.submit(()->{
				System.out.print(count.getAndIncrement() +" ");
			});
		}
	}

}
