package practice2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StudentList {
	public static void main(String[] args) {
		Student s1 = new Student(1, "Rajesh");
		Student s2 = new Student(2, "Amey");
		Student s3 = new Student(3, "Sanjay");

		List<Student> al = Arrays.asList(s1, s2, s3);

		//sort by name
		
		Collections.sort(al, (a,b)-> a.name.compareTo(b.name));
		
		for (Student s : al) {
			System.out.println(s.rollNum + " " + s.name);
		}
	}

}

class Student {

	int rollNum;
	String name;

	Student(int rollNum, String name) {
		this.rollNum = rollNum;
		this.name = name;

	}
}