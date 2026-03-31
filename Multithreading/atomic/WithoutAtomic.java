package atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WithoutAtomic {
	private static Integer count = 0;

	public static void main(String[] args) {

		ExecutorService service = Executors.newFixedThreadPool(10);
		try {
			for (int i = 0; i < 10; i++) {
				service.submit(() -> {
					System.out.print(++count + " ");
				});
			}
		} finally {
			if (service != null) {
				service.shutdown();
			}
		}

	}

}

// output -> 1 3 2 1 4 5 6 8 7 9 