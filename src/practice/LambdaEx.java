package practice;

interface Drawable{
	void draw();
}


public class LambdaEx {
	
	public static void methodRef() {
		System.out.println("This is fucntional interface example");
	}
	
	public static void main(String[] args) {

		
		Drawable d =()->{
			System.out.println("this is implementation");
		};
		
		d.draw();
		
		Drawable d1 = LambdaEx::methodRef;
		d1.draw();
		
		
	}
}
