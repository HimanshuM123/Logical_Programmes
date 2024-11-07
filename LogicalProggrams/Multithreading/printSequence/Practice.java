package printSequence;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Practice {
	public static void main(String[] args) {
		
		String str = "abcdefghijklmn";
		
		str.chars().forEach(obj -> {
			
			System.out.println((char)obj);
		});
		
		
		
		
	}

}
