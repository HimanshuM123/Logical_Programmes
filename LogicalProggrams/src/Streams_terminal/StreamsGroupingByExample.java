package Streams_terminal;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import java8.Student;
import java8.StudentDataBase;

public class StreamsGroupingByExample {

	public static void groupByGender() {

		Map<String, List<Student>> studentMap = StudentDataBase.getAllStudents().stream()
				.collect(Collectors.groupingBy(Student::getGender));

		System.out.println(studentMap);
	}

	public static void customizeGroupingBy() {

		Map<String, List<Student>> studentMap = StudentDataBase.getAllStudents().stream()
				.collect(Collectors.groupingBy(student -> student.getGpa() >= 3.8 ? "OUTSTANDING" : "AVERAGE"));

		System.out.println(studentMap);
	}
	
	public static void twoLevelGrouping_1() {
	Map<Integer,Map<String,List<Student>>> studentMap=	StudentDataBase.getAllStudents().stream()
		.collect(Collectors.groupingBy(Student::getGradeLevel,
				Collectors.groupingBy(student -> student.getGpa() >= 3.8 ? "OUTSTANDING" : "AVERAGE")));
	System.out.println(studentMap);
	}
	
	public static void twoLevelGrouping_2() {
		Map<Integer,Integer> studentMap=	StudentDataBase.getAllStudents().stream()
			.collect(Collectors.groupingBy(Student::getGradeLevel,
					Collectors.summingInt(Student::getNoteBooks)));
		System.out.println(studentMap);
		}
	
	public static void threeArgsGroupBy() {
		LinkedHashMap<String,Set<Student>> studentMap=StudentDataBase.getAllStudents()
		.stream()
		.collect(Collectors.groupingBy(Student::getName,LinkedHashMap::new,Collectors.toSet()));
		System.out.println(studentMap);
		
	}
	
	public static void calculateTopGpa() {
	Map<Integer,Optional<Student>> studentMap=	StudentDataBase.getAllStudents()
		.stream()
		.collect(Collectors.groupingBy(Student::getGradeLevel,Collectors.maxBy(Comparator.comparing(Student::getGpa))));
		System.out.println(studentMap);
	}

	public static void main(String[] args) {
		groupByGender();
		customizeGroupingBy();
		twoLevelGrouping_1();
		threeArgsGroupBy();
		calculateTopGpa();
	}
}
