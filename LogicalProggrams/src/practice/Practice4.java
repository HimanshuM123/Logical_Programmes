package practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Practice4 {
	static int count = 0;
	static AtomicInteger at = new AtomicInteger(0);
	public static void main(String[] args) {

		

		ExecutorService exe = Executors.newFixedThreadPool(10);

		for (int i = 0; i < 10; i++) {

			exe.submit(() -> {
				System.out.print(at.getAndIncrement() +" ");

			});

		}
		exe.shutdown();

	}

}
