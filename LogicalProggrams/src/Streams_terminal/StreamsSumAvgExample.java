package Streams_terminal;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import java8.StudentDataBase;
import java8.Student;

public class StreamsSumAvgExample {

	
	public static int sum() {
		return StudentDataBase.getAllStudents()
		.stream()
		.collect(Collectors.summingInt(Student::getNoteBooks));
	}//71
	
	public static double avg() {
		return StudentDataBase.getAllStudents()
		.stream()
		.collect(Collectors.averagingInt(Student::getNoteBooks));
	}//11.833333333333334


	public static void main(String[] args) {
		System.out.println(sum());
		System.out.println(avg());
	}

}
