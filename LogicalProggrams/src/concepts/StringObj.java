package concepts;

public class StringObj {
	public static void main(String[] args) {
		String s1 = new String("ABC"); // 2 objects(1 in heap + 1 in pool)
		String s2 = "ABC"; // point to already created object
		String s3 = new String("ABC"); // 1 object(1 in heap) & other it will point to already created object in pool
		
		//total = 2 in heap + 1 in String constant pool
		
	}

}
