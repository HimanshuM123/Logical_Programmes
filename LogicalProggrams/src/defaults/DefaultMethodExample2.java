package defaults;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import java8.Student;
import java8.StudentDataBase;

public class DefaultMethodExample2 {

	static Consumer<Student> studentConsumer = (student) -> System.out.println(student);
	static Comparator<Student> nameComparator = Comparator.comparing(Student::getName);
	static Comparator<Student> gradeComparator = Comparator.comparing(Student::getGradeLevel);

	public static void sortByname(List<Student> studentList) {
		System.out.println("After sort Name");
		Comparator<Student> nameComparator = Comparator.comparing(Student::getName);
		studentList.sort(nameComparator);
		studentList.forEach(studentConsumer);

	}
	
	public static void sortByGpa(List<Student> studentList) {
		System.out.println("After sort GPA");
		Comparator<Student> gpaComparator = Comparator.comparingDouble(Student::getGpa);
		studentList.sort(gpaComparator);
		studentList.forEach(studentConsumer);

	}
	
	public static void comparatorChaining(List<Student> studentList) {
		System.out.println("After comparatorChaining");
		studentList.sort(gradeComparator.thenComparing(nameComparator));
		studentList.forEach(studentConsumer);
		
	}
	
	public static void sortWithNullValues(List<Student> studentList) {
		System.out.println("After sort sortWithNullValues");
		//Comparator<Student> studentComparator = Comparator.nullsFirst(nameComparator);
		Comparator<Student> studentComparator = Comparator.nullsLast(nameComparator);
		studentList.sort(studentComparator);
		studentList.forEach(studentConsumer);

	}

	public static void main(String[] args) {
		List<Student> studentList = StudentDataBase.getAllStudents();
		System.out.println("Before sort");
		studentList.forEach(studentConsumer);
		/*sortByname(studentList);
		sortByGpa(studentList);
		comparatorChaining(studentList);*/
		sortWithNullValues(studentList);
	}

}
