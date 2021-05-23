package java8;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import java8.Student;
import java8.StudentDataBase;

public class StreamsExample {
	public static void main(String[] args) {

		Predicate<Student> studentPredicate = (student -> student.getGradeLevel() >= 3);
		Predicate<Student> studentGpaPredicate = (student -> student.getGpa() >= 3.9);

		Map<String, List<String>> studentMap = StudentDataBase.getAllStudents()
				.stream()
				.peek(student ->{//debug purpose
					System.out.println(student);
				})
				.filter(studentPredicate)
				.peek(student ->{
					System.out.println("after first Filter......"+student);
				})
				.filter(studentGpaPredicate)
				.peek(student ->{
					System.out.println("after second Filter......"+student);
				})
				.collect(Collectors.toMap(Student::getName, Student::getActivities));

		System.out.println(studentMap);
	}

}
