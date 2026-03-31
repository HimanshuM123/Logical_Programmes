package java8;

import java.util.List;
import java.util.function.Predicate;

public class F_PredicateExample_2 {

	static Predicate<Student> p1 = (s) -> s.getGradeLevel() >= 3;
	static Predicate<Student> p2 = (s) -> s.getGpa() >= 3.9;

	public static void filterStudentByGradeLevel() {
		List<Student> studentList=StudentDataBase.getAllStudents();
		System.out.println("Grade level=====================");
		studentList.forEach((student ->{
			if(p1.test(student)) {
				System.out.println(student);
			}
			
		}));
	}
	
	public static void filterStudentByGPA() {
		List<Student> studentList=StudentDataBase.getAllStudents();
		System.out.println("GPA=====================");
		studentList.forEach((student ->{
			if(p2.test(student)) {
				System.out.println(student);
			}
			
		}));
	}
	
	public static void filterStudents() {
		List<Student> studentList=StudentDataBase.getAllStudents();
		System.out.println("filterStudents=====================");
		studentList.forEach((student ->{
			if(p1.and(p2).test(student)) {
				System.out.println(student);
			}
			
		}));
	}

	public static void main(String[] args) {
		filterStudentByGradeLevel();
		filterStudentByGPA();
		filterStudents();
	}

}
