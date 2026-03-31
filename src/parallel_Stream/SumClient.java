package parallel_Stream;

import java.io.InputStream;
import java.util.stream.IntStream;

public class SumClient {

	public static void main(String[] args) {
		
		Sum sum=new Sum();
		//expected 500500
		IntStream.rangeClosed(1, 1000)
		.parallel()
		.forEach(sum::performSum);
		
		System.out.println(sum.getTotal());
		//with parallel
		//469799
		//457337
		//479699
		//recomendation >- for mutable variable do not use parallel stream approch
		
	}
}
