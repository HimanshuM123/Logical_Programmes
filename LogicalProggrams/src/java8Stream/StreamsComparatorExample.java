package java8Stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import java8.Student;
import java8.StudentDataBase;

public class StreamsComparatorExample {

	public static List<Student> sortStudentsByName() {

		return StudentDataBase.getAllStudents()
				.stream()
			//	.sorted(Comparator.comparing(obj -> obj.getName()))
				.sorted(Comparator.comparing(Student::getName))
				.collect(Collectors.toList());

	}
	
	public static List<Student> sortStudentsByGpa() {

		return StudentDataBase.getAllStudents()
				.stream()
				.sorted(Comparator.comparing(Student::getGpa))
				.collect(Collectors.toList());

	}
	
	public static List<Student> sortStudentsByGpaDesc() {

		return StudentDataBase.getAllStudents()
				.stream()
				.sorted(Comparator.comparing(Student::getGpa).reversed())
				.collect(Collectors.toList());

	}

	public static void main(String[] args) {
		System.out.println("Student sorted by name............");
		sortStudentsByName().forEach(System.out::println);
		System.out.println("Student sorted by GPA............");
		sortStudentsByGpa().forEach(System.out::println);
		System.out.println("Student sorted by GPA desc............");
		sortStudentsByGpaDesc().forEach(System.out::println);
	}

}
