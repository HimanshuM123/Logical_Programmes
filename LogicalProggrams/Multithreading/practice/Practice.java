package practice;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Practice {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService ex = Executors.newFixedThreadPool(10);

		Future f1 = ex.submit(new Future5());

		System.out.println(f1.get());

	}

}

class Future5 implements Callable {

	@Override
	public Double call() throws Exception {
		// TODO Auto-generated method stub
		return Math.random();
	}

}
