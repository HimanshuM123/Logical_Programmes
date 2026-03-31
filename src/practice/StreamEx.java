package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Student {
	String name;
	int marks;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	Student(String name, int marks) {
		this.name = name;
		this.marks = marks;
	}
}

public class StreamEx {
	public static void main(String[] args) {
		List<Integer> al = Arrays.asList(1, 2, 3, 4, 5, 6);

		// max number
		Optional<Integer> maxNum = al.stream().max((a, b) -> a.compareTo(b));
		System.out.println("Max number is " + maxNum.get());

		// min number

		Optional<Integer> minNum = al.stream().min((a, b) -> a.compareTo(b));
		System.out.println("Max number is " + minNum.get());

		// count
		Long count = al.stream().count();
		System.out.println("The count is " + count);

		// sum
		Integer sum = al.stream().reduce(0, (a, b) -> a + b);
		System.out.println("The sum is " + sum);

		// even numbers
		List<Integer> result = al.stream().filter(a -> a % 2 == 0).collect(Collectors.toList());
		System.out.println(result);

		// reverse order
		List<Integer> rev = al.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(rev);
		
		
		Student s1 = new Student("Ramesh", 60);
		Student s2 =  new Student("Suresh",80);
		Student s3 =  new Student("Amar",40);
		List<Student> students = Arrays.asList(s1,s2,s3);
		//marks list
		List<Integer> marksList = students.stream().map(Student::getMarks).collect(Collectors.toList());
		System.out.println("Marks List "+marksList);
		
		//sort by marks
		List<Student> result2= students.stream().sorted(Comparator.comparing(Student::getMarks)).collect(Collectors.toList());
		result2.forEach(a -> System.out.println(a.name+" "+a.marks));
		
		//average of marks
		OptionalDouble avg = students.stream().mapToInt(Student::getMarks).average();
		System.out.println("Average "+avg.getAsDouble());
		
		//flatmap
		//List <String> d =students.stream().map(s -> s.getName()).flatMap(b -> b.stream()).collect(Collectors.toList());
	}
}
