package atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class WithAtomic {
	private static AtomicInteger counter = new AtomicInteger();

	public static void main(String[] args) {

		ExecutorService service = Executors.newFixedThreadPool(10);
		try {
			for (int i = 0; i < 10; i++) {
				service.submit(() -> {
					System.out.print(counter.incrementAndGet()+ " ");
				});
			}
		} finally {
			if (service != null) {
				service.shutdown();
			}
		}

	}
}
//output -> 1 4 3 2 5 6 7 8 9 10 
//          3 4 5 1 2 6 7 9 10 8 
// out of sequence but we dont have duplicate or missing number