package java8;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class F_FunctionStudentExample {

	static Function<List<Student>, Map<String, Double>> studentFunction = (students -> {
		Map<String, Double> sudentGradeMap = new HashMap<>();
		students.forEach(student -> {
			sudentGradeMap.put(student.getName(), student.getGpa());
		});
		return sudentGradeMap;
	});

	public static void main(String[] args) {
		System.out.println(studentFunction.apply(StudentDataBase.getAllStudents()));
	}

}
