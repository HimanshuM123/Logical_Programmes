package Streams_terminal;

import java.util.stream.Collectors;

import java8.Student;
import java8.StudentDataBase;

public class StreamsJoiningExample {

	public static String joining_1() {
		return StudentDataBase.getAllStudents().stream()
				.map(Student::getName)
				.collect(Collectors.joining());
//Joining1 AdamJennyEmilyDaveSophiaJames

	}
	
	public static String joining_2() {
		return StudentDataBase.getAllStudents().stream()
				.map(Student::getName)
				.collect(Collectors.joining("-"));
//Joining2 Adam-Jenny-Emily-Dave-Sophia-James

	}
	
	public static String joining_3() {
		return StudentDataBase.getAllStudents().stream()
				.map(Student::getName)
				.collect(Collectors.joining("-","(",")"));
//Joining3 (Adam-Jenny-Emily-Dave-Sophia-James)

	}


	public static void main(String[] args) {
		System.out.println("Joining1 " + joining_1());
		System.out.println("Joining2 " + joining_2());
		System.out.println("Joining3 " + joining_3());
	}
}

/*
Joining1 AdamJennyEmilyDaveSophiaJames
Joining2 Adam-Jenny-Emily-Dave-Sophia-James
Joining3 (Adam-Jenny-Emily-Dave-Sophia-James)

*/