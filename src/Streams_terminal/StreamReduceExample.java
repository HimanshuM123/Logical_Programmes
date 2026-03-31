package Streams_terminal;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import java8.Student;
import java8.StudentDataBase;

public class StreamReduceExample {
	
	
	public static int performMultiplication(List<Integer> integerList) {
		//1,3,5,7
		//a=1,b=1(from stream)=> result 1 is return
		//a=1,b=3(from stream)=> result 3 is return
		//a=3,b=5(from stream)=> result 15 is return
		//a=15,b=7(from stream)=> result 15 is return
		
		return integerList.stream()
				.reduce(1, (a,b)->a*b);
		
	}
	
	public static Optional<Integer> performMultiplicationWithoutIdentity(List<Integer> integerList) {
		return integerList.stream()
				.reduce((a,b)->a*b);
		
	}
	
	public static Optional<Student> getHighestGPAStudent(){
		
		return StudentDataBase.getAllStudents().stream()
		.reduce((s1,s2)-> s1.getGpa()>s2.getGpa()?s1:s2);
	}
	
	public static void main(String[] args) {
		List<Integer> integers=Arrays.asList(1,3,5,7);
		System.out.println("Perform multiplication");
		System.out.println(performMultiplication(integers));
		
		Optional<Integer> result=performMultiplicationWithoutIdentity(integers);
		System.out.println(result.isPresent());
		System.out.println(result.get());
		
		Optional<Student> optionalStudent=getHighestGPAStudent();
		if(optionalStudent.isPresent()) {
			System.out.println(optionalStudent.get());
		}
	}

}
