package parallel_Stream;

import java.util.List;
import java.util.stream.Collectors;

import java8.Student;
import java8.StudentDataBase;

public class ParallelStramExample1 {
	
public static List<String> sequentialPrintStudentActivities(){
		long startTime=System.currentTimeMillis();
		List<String> studentActivities=StudentDataBase.getAllStudents().stream()//Stream<List<Student>>
				.map(Student::getActivities)//stream<List<String>>
				.flatMap(List::stream)//Stream<String>>
				.distinct()
				.sorted()
				.collect(Collectors.toList());
		long endTime=System.currentTimeMillis();
		System.out.println("Duration to excecute the pipiline in sequential "+(endTime-startTime));
		 return studentActivities;
		
	}

public static List<String> parallelPrintStudentActivities(){
	long startTime=System.currentTimeMillis();
	List<String> studentActivities=StudentDataBase.getAllStudents().stream()//Stream<List<Student>>
			.parallel()
			.map(Student::getActivities)//stream<List<String>>
			.flatMap(List::stream)//Stream<String>>
			.distinct()
			.sorted()
			.collect(Collectors.toList());
	long endTime=System.currentTimeMillis();
	System.out.println("Duration to excecute the pipiline in parallel "+(endTime-startTime));
	
	 return studentActivities;
	
}


		public static void main(String[] args) {
			sequentialPrintStudentActivities();
			parallelPrintStudentActivities();
		}
}
