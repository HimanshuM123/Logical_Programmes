package Streams_terminal;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import java8.StudentDataBase;
import java8.Student;

public class StreamsMappingExample {
	public static void main(String[] args) {
		
	List<String> studentNames1=StudentDataBase.getAllStudents()
			.stream()
			.map(Student::getName)
			.collect(Collectors.toList());//without mapping
	
	List<String> studentNames2=StudentDataBase.getAllStudents()
			.stream()
			.collect(Collectors.mapping(Student::getName, Collectors.toList()));//reduces to one line code
	
	Set<String> set=StudentDataBase.getAllStudents()
			.stream()
			.collect(Collectors.mapping(Student::getName, Collectors.toSet()));
	
	System.out.println(studentNames1);
	System.out.println(studentNames2);
	System.out.println(set);
	}
}
