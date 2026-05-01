package java8Stream;

import java.util.Optional;

import java8.Student;
import java8.StudentDataBase;

public class StreamFindAnyFirstExample {

	public static Optional<Student> findAnyStudent(){
		return StudentDataBase.getAllStudents().stream()
		.filter(student -> student.getGpa()>=3.9)
		.findAny();
		
	}
	
	public static Optional<Student> findFirstStudent(){
		return StudentDataBase.getAllStudents().stream()
		.filter(student -> student.getGpa()>=3.9)
		.findFirst();
		
	}
	public static void main(String[] args) {
		Optional<Student> studentOptionalFindAny=findAnyStudent();
		if(studentOptionalFindAny.isPresent()) {
			System.out.println("Found the student "+studentOptionalFindAny.get());
		}else {
			System.out.println("No student found");
		}
		
		Optional<Student> studentOptionalFindFirst=findFirstStudent();
		if(studentOptionalFindFirst.isPresent()) {
			System.out.println("Found the student "+studentOptionalFindFirst.get());
		}else {
			System.out.println("No student found");
		}
	}
}
