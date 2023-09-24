package java8Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamEx {

	public static void main(String[] args) {
		
		Student st1=new Student(3,"Rahul",40);
		Student st2=new Student(2,"Dipesh",60);
		Student st3=new Student(1,"Deepti",55);
		Student st4=new Student(6,"Amar",90);
		Student st5=new Student(8,"Jayesh",88);
		
		List<Student> students = Arrays.asList(st1,st2,st3,st4,st5);
		
		//students having first class
		
		List<String> firstClassList = students.stream()
				                      .filter(s -> s.marks >=60)
				                      .map(Student::getName)
				                      .collect(Collectors.toList());
				System.out.println("firstClassList  "+firstClassList);
				
		// Maximum marks
			Optional<String> max_marks_name=	students.stream()
					                            .max(Comparator.comparing(Student::getMarks))
					                            .map(Student::getName);
			System.out.println("Student with max marks "+max_marks_name);
			
			//sort by max marks
			List<String> students1=	students.stream()
					                 .sorted(Comparator.comparing(Student::getMarks).reversed())
					                 .map(Student::getName)
					                 .collect(Collectors.toList());
			System.out.println("Students with sorted marks "+students1);
			
			//count students haveing more than 80
			Long count =students.stream().filter(s -> s.marks >80).collect(Collectors.counting());
			System.out.println("Studnets having more than 80% -> "+count);
			
			//sum of marks
			int totalMarks =students.stream().map(Student::getMarks).reduce(0, (a,b)-> a+b);
			System.out.println("The total marks are "+totalMarks);
			
			//average marks
			
			double averageMarks = students.stream().collect(Collectors.averagingInt(Student::getMarks));
			System.out.println("The average marks are "+averageMarks);
	}

}
