package java8;

interface Drawable {
	public void draw();
}

public class Lamda1 {
	public static void main(String[] args) {
		int width = 10;
		Drawable d = () -> {
			System.out.println("The width is " + width);
		};

		d.draw();

	}

}
