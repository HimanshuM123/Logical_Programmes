package optional;

import java.util.Optional;

import java8.Student;
import java8.StudentDataBase;

public class OptionalExample {

	public static String getStudentName() {

		Student student = StudentDataBase.studentSupplier.get();

		if (student != null) {
			return student.getName();
		}
		return null;

	}//null check is not advisable as anything can be null String,Integer,Student...
	
	public static Optional<String> getStudentNameOptional() {

		Optional<Student> studentOptional=Optional.ofNullable(StudentDataBase.studentSupplier.get());
		if(studentOptional.isPresent()) {
			return studentOptional.map(Student::getName);
		}
			return Optional.empty();//optional returns unique empty object

	}

	public static void main(String[] args) {
			String name=getStudentName();
			
			System.out.println("length of student name "+name.length());
			
			Optional<String> stringOptional=getStudentNameOptional();
			if(stringOptional.isPresent()) {
				System.out.println(stringOptional.get().length());
			}
	}

}
