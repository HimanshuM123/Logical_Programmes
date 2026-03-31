package Streams_terminal;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import java8.Student;
import java8.StudentDataBase;

public class StreamsPartitioningByExample {

	public static void partitioningBy_1() {
		Predicate<Student> gpaPredicate= student -> student.getGpa()>=3.8;
		
	Map<Boolean, List<Student>> map=	StudentDataBase.getAllStudents()
		.stream()
		.collect(Collectors.partitioningBy(gpaPredicate));
	
	System.out.println(map);
	}	
	
	public static void main(String[] args) {
		partitioningBy_1();
	}
}
