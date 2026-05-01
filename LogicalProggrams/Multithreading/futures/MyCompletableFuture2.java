package futures;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MyCompletableFuture2 {
	private static int getNumber(int a) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a * a;
	}

	private static int getNumber2(int a) {
		return a * a;
	}

	public static void main(String[] args) {
		try {
			System.out.println("Main Thread started");
			CompletableFuture<Integer> res1 = CompletableFuture.supplyAsync(() -> getNumber(2));

			CompletableFuture<Integer> res2 = CompletableFuture.supplyAsync(() -> getNumber2(2));

			CompletableFuture.allOf(res1, res2).join();
			System.out.println("Main Thread completed!!!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
