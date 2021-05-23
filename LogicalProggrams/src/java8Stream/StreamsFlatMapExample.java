package java8Stream;

import java.util.List;
import java.util.stream.Collectors;

import java8.Student;
import java8.StudentDataBase;

public class StreamsFlatMapExample {
	
	//stream<List<String>> --> stream<String>>
public static List<String> printStudentActivities(){
		
		List<String> studentActivities=StudentDataBase.getAllStudents().stream()//Stream<List<Student>>
				.map(Student::getActivities)//stream<List<String>>
				.flatMap(List::stream)//Stream<String>>
				.distinct()
				.sorted()
				.collect(Collectors.toList());
		
		 return studentActivities;
		
	}

public static Long getStudentActivitiesCount(){
	
	Long studentActivitiesCount=StudentDataBase.getAllStudents().stream()//Stream<Student>
			.map(Student::getActivities)//stream<List<String>>
			.flatMap(List::stream)//Stream<String>>
			.distinct()
			.count();
	
	 return studentActivitiesCount;
	
}
	public static void main(String[] args) {
		System.out.println(printStudentActivities());
		System.out.println(getStudentActivitiesCount());
	}

}
