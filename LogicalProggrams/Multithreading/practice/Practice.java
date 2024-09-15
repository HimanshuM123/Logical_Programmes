package practice;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Practice {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService ex = Executors.newFixedThreadPool(10);
		Future<Integer> f=  ex.submit(new MyClass2());
		System.out.println("...............");
		System.out.println(f.get());
	}

}


class MyClass2 implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		Thread.sleep(5000);
		return 4;
	}
	
}