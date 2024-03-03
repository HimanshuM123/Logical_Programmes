package concepts;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorEx {

	public static void main(String[] args) {
		Student2 s1 = new Student2(1, 24, "Rahul");
		Student2 s2 = new Student2(2, 18, "Suresh");
		Student2 s3 = new Student2(3, 20, "Anita");

		List<Student2> al = Arrays.asList(s1, s2, s3);
//		Collections.sort(al, new AgeComparator());
		Collections.sort(al, new NameComparator());

		for (Student2 obj : al) {
			System.out.print(obj.name + " ");
		}
	}

}

class AgeComparator implements Comparator<Student2> {

	@Override
	public int compare(Student2 s1, Student2 s2) {
		if (s1.age == s2.age) {
			return 0;
		}
		if (s1.age > s2.age) {
			return 1;

		}
		if (s1.age < s2.age) {
			return -1;

		}
		return 0;
	}

}

class NameComparator implements Comparator<Student2> {

	@Override
	public int compare(Student2 o1, Student2 o2) {
		return o1.name.compareTo(o2.name);
	}

}