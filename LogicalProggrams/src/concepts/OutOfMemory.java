package concepts;

public class OutOfMemory {
	//heap memory full
	public static void main(String[] args) {
		long[][] ary = new long[Integer.MAX_VALUE][Integer.MAX_VALUE];
		System.out.println(ary);

	}

}
