package concepts;

public class Strings {
	
	public static void main(String[] args) {
		String str1 = new String("Apple");//Two objects will be created
		String str2= "Apple";//one object will be created
		//Total 2 objects will be created
		
		System.out.println(str1.intern().hashCode()==str2.hashCode());//true
		//intern method will get object from string pool area
		
		System.out.println(str1.intern().hashCode());//63476538
		System.out.println(str2.hashCode());//63476538
		
	}

}
