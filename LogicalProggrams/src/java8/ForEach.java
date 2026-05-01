package java8;

import java.util.ArrayList;
import java.util.List;

public class ForEach {

	public static void main(String[] args) {
		List<String> al = new ArrayList<String>();
		al.add("Java");
		al.add("C++");
		al.add("python");

		al.forEach((n) -> {
			System.out.println(n);
		});
	}

}
