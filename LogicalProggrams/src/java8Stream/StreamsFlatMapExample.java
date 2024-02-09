package java8Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import java8.Student;
import java8.StudentDataBase;

public class StreamsFlatMapExample {

	// stream<List<String>> --> stream<String>>
	public static List<String> printStudentActivities() {

		List<String> studentActivities = StudentDataBase.getAllStudents().stream()// Stream<List<Student>>
				// .map(Student::getActivities)//Stream<List<String>>
				.map(x -> x.getActivities())
				// .flatMap(List::stream)//Stream<String>>
				.flatMap(y -> y.stream()).distinct().sorted().collect(Collectors.toList());

		return studentActivities;

	}

	public static Long getStudentActivitiesCount() {

		Long studentActivitiesCount = StudentDataBase.getAllStudents().stream()// Stream<Student>
				.map(Student::getActivities)// stream<List<String>>
				.flatMap(List::stream)// Stream<String>>
				.distinct().count();

		return studentActivitiesCount;

	}

	private static void flatMapEx() {
		List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5),
				Arrays.asList(6, 7, 8));
		System.out.println("Before flattening"+listOfLists);

		List<Integer> flattenedList = listOfLists.stream().flatMap(y -> y.stream()) // Flattening step
				.collect(Collectors.toList());
		


		// Prints [1, 2, 3, 4, 5, 6, 7, 8]
		System.out.println("Flattened list: " + flattenedList);
		/*
		 * Before flattening : [[1, 2, 3], [4, 5], [6, 7, 8]]
		 * 
		 * After flattening : [1, 2, 3, 4, 5, 6, 7, 8]
		 */
	}

	public static void main(String[] args) {
		System.out.println(printStudentActivities());
		System.out.println(getStudentActivitiesCount());
		flatMapEx();
	}

}
