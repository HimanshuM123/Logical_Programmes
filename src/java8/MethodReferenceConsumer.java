package java8;

import java.util.function.Consumer;

public class MethodReferenceConsumer {

	static Consumer<Student> c1 = (p) -> System.out.println(p);
	static Consumer<Student> c2 = System.out::println;
	static Consumer<Student> c3 = Student::printListOfActivities;

	public static void main(String[] args) {
		StudentDataBase.getAllStudents().forEach(c1);
		System.out.println("======================");
		StudentDataBase.getAllStudents().forEach(c2);
		System.out.println("======================");
		StudentDataBase.getAllStudents().forEach(c3);
	}
}
