package singleThreadExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutor {
	public static void main(String[] args) {
		System.out.println("Start of Main Thread");
		Runnable task1 = () -> {
			System.out.println("Task1 Simple Print");
		};

		Runnable task2 = () -> {
			for (int i = 0; i < 4; i++) {
				System.out.println("Task2 " + i);
			}

		};
		ExecutorService e = null;

		try {
			e = Executors.newSingleThreadExecutor();
			e.execute(task1);
			e.execute(task2);
			e.execute(task1);
		} finally {
			if (e != null) {
				e.shutdown();
			}
		}

		System.out.println("End of Main Thread");
	}

}

/*
Task executes sequentially but parallel to main thread
this will manage only 1 thread

Start of Main Thread
Task1 Simple Print
End of Main Thread
Task2 0
Task2 1
Task2 2
Task2 3
Task1 Simple Print


*/