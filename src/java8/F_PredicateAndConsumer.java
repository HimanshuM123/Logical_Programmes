package java8;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class F_PredicateAndConsumer {

	Predicate<Student> p1 = (s) -> s.getGradeLevel() >= 3;
	Predicate<Student> p2 = (s) -> s.getGpa() >= 3.8;

	BiPredicate<Integer, Double> biPredicate = (gradeLevel, gpa) -> gradeLevel >= 3 && gpa >= 3.9;

	BiConsumer<String, List<String>> studentBiconsumer = (name, activities) -> System.out
			.println(name + ":" + activities);

	Consumer<Student> studentConsumer = (student -> {
		// if(p1.and(p2).test(student)) {
		if (biPredicate.test(student.getGradeLevel(), student.getGpa())) {
			studentBiconsumer.accept(student.getName(), student.getActivities());
		}
	});

	public void printNameAndActivities(List<Student> student) {
		student.forEach(studentConsumer);
	}

	public static void main(String[] args) {
		List<Student> studentList = StudentDataBase.getAllStudents();
		new F_PredicateAndConsumer().printNameAndActivities(studentList);
	}

}
