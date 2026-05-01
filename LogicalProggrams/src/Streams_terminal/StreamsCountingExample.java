package Streams_terminal;

import java.util.stream.Collectors;

import java8.StudentDataBase;

public class StreamsCountingExample {
	
	public static long count() {
		return StudentDataBase.getAllStudents().stream()
		.filter(student -> student.getGpa()>=3.9)
		.collect(Collectors.counting());
	}
	
	
	public static void main(String[] args) {
		System.out.println(count()); //3

	}
}
