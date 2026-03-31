package concepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ComparableEx {
	public static void main(String... args) {
		Student2 s1 = new Student2(1,24,"Rahul");
		Student2 s2 = new Student2(2,18,"Ramesh");
		Student2 s3 = new Student2(3,20,"Riya");
		
		List<Student2> al = Arrays.asList(s1,s2,s3);
		Collections.sort(al);
		
		for(Student2 obj : al) {
			System.out.print(obj.name+" ");
		}
	}
}

class Student2 implements Comparable<Student2>{
	int id;
	int age;
	String name;

	public Student2(int id, int age, String name) {
		super();
		this.id = id;
		this.age = age;
		this.name = name;
	}

	@Override
	public int compareTo(Student2 s) {
		if(s.age==age) {
			return 0;
		}
		if(s.age > age) {
			return -1;
		}
		if(s.age < age) {
			return 1;
		}
		return 0;
	}

}
