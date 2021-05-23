package Streams_terminal;

import java.util.stream.Collectors;

import java8.StudentDataBase;
import java8.Student;

public class StreamsSumAvgExample {

	public static int sum() {
		return StudentDataBase.getAllStudents()
		.stream()
		.collect(Collectors.summingInt(Student::getNoteBooks));
	}
	
	public static double avg() {
		return StudentDataBase.getAllStudents()
		.stream()
		.collect(Collectors.averagingInt(Student::getNoteBooks));
	}

	public static void main(String[] args) {
		System.out.println(sum());
		System.out.println(avg());
	}

}
