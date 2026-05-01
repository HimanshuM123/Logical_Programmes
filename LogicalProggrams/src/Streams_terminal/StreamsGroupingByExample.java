package Streams_terminal;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import java8.Student;
import java8.StudentDataBase;

public class StreamsGroupingByExample {

	public static void groupByGender() {

		Map<String, List<Student>> studentMap = StudentDataBase.getAllStudents().stream()
				.collect(Collectors.groupingBy(Student::getGender));

		System.out.println(studentMap);
		//{female=[Student [name=Jenny, gradeLevel=2, gpa=3.8, gender=female, activities=[swimming, gymnastics, soccer], noteBooks=12, bike=Optional.empty], Student [name=Emily, gradeLevel=3, gpa=4.0, gender=female, activities=[swimming, gymnastics, aerobics], noteBooks=10, bike=Optional.empty], Student [name=Sophia, gradeLevel=4, gpa=3.5, gender=female, activities=[swimming, dancing, football], noteBooks=15, bike=Optional.empty]], male=[Student [name=Adam, gradeLevel=2, gpa=3.6, gender=male, activities=[swimming, basketball, volleyball], noteBooks=11, bike=Optional.empty], Student [name=Dave, gradeLevel=3, gpa=3.9, gender=male, activities=[swimming, gymnastics, soccer], noteBooks=9, bike=Optional.empty], Student [name=James, gradeLevel=4, gpa=3.9, gender=male, activities=[swimming, basketball, baseball, football], noteBooks=14, bike=Optional.empty]]}

	}

	public static void customizeGroupingBy() {

		Map<String, List<Student>> studentMap = StudentDataBase.getAllStudents().stream()
				.collect(Collectors.groupingBy(student -> student.getGpa() >= 3.8 ? "OUTSTANDING" : "AVERAGE"));

		System.out.println(studentMap);
		//{AVERAGE=[Student [name=Adam, gradeLevel=2, gpa=3.6, gender=male, activities=[swimming, basketball, volleyball], noteBooks=11, bike=Optional.empty], Student [name=Sophia, gradeLevel=4, gpa=3.5, gender=female, activities=[swimming, dancing, football], noteBooks=15, bike=Optional.empty]], OUTSTANDING=[Student [name=Jenny, gradeLevel=2, gpa=3.8, gender=female, activities=[swimming, gymnastics, soccer], noteBooks=12, bike=Optional.empty], Student [name=Emily, gradeLevel=3, gpa=4.0, gender=female, activities=[swimming, gymnastics, aerobics], noteBooks=10, bike=Optional.empty], Student [name=Dave, gradeLevel=3, gpa=3.9, gender=male, activities=[swimming, gymnastics, soccer], noteBooks=9, bike=Optional.empty], Student [name=James, gradeLevel=4, gpa=3.9, gender=male, activities=[swimming, basketball, baseball, football], noteBooks=14, bike=Optional.empty]]}

	}
	
	public static void twoLevelGrouping_1() {
	Map<Integer,Map<String,List<Student>>> studentMap=	StudentDataBase.getAllStudents().stream()
		.collect(Collectors.groupingBy(Student::getGradeLevel,
				Collectors.groupingBy(student -> student.getGpa() >= 3.8 ? "OUTSTANDING" : "AVERAGE")));
	System.out.println(studentMap);
	//{2={AVERAGE=[Student [name=Adam, gradeLevel=2, gpa=3.6, gender=male, activities=[swimming, basketball, volleyball], noteBooks=11, bike=Optional.empty]], OUTSTANDING=[Student [name=Jenny, gradeLevel=2, gpa=3.8, gender=female, activities=[swimming, gymnastics, soccer], noteBooks=12, bike=Optional.empty]]}, 3={OUTSTANDING=[Student [name=Emily, gradeLevel=3, gpa=4.0, gender=female, activities=[swimming, gymnastics, aerobics], noteBooks=10, bike=Optional.empty], Student [name=Dave, gradeLevel=3, gpa=3.9, gender=male, activities=[swimming, gymnastics, soccer], noteBooks=9, bike=Optional.empty]]}, 4={AVERAGE=[Student [name=Sophia, gradeLevel=4, gpa=3.5, gender=female, activities=[swimming, dancing, football], noteBooks=15, bike=Optional.empty]], OUTSTANDING=[Student [name=James, gradeLevel=4, gpa=3.9, gender=male, activities=[swimming, basketball, baseball, football], noteBooks=14, bike=Optional.empty]]}}

	}
	
	public static void twoLevelGrouping_2() {
		Map<Integer,Integer> studentMap=	StudentDataBase.getAllStudents().stream()
			.collect(Collectors.groupingBy(Student::getGradeLevel,
					Collectors.summingInt(Student::getNoteBooks)));
		System.out.println(studentMap);

		}
	
	public static void threeArgsGroupBy() {
		LinkedHashMap<String,Set<Student>> studentMap=StudentDataBase.getAllStudents()
		.stream()
		.collect(Collectors.groupingBy(Student::getName,LinkedHashMap::new,Collectors.toSet()));
		System.out.println(studentMap);
		//{Adam=[Student [name=Adam, gradeLevel=2, gpa=3.6, gender=male, activities=[swimming, basketball, volleyball], noteBooks=11, bike=Optional.empty]], Jenny=[Student [name=Jenny, gradeLevel=2, gpa=3.8, gender=female, activities=[swimming, gymnastics, soccer], noteBooks=12, bike=Optional.empty]], Emily=[Student [name=Emily, gradeLevel=3, gpa=4.0, gender=female, activities=[swimming, gymnastics, aerobics], noteBooks=10, bike=Optional.empty]], Dave=[Student [name=Dave, gradeLevel=3, gpa=3.9, gender=male, activities=[swimming, gymnastics, soccer], noteBooks=9, bike=Optional.empty]], Sophia=[Student [name=Sophia, gradeLevel=4, gpa=3.5, gender=female, activities=[swimming, dancing, football], noteBooks=15, bike=Optional.empty]], James=[Student [name=James, gradeLevel=4, gpa=3.9, gender=male, activities=[swimming, basketball, baseball, football], noteBooks=14, bike=Optional.empty]]}

		
	}
	
	public static void calculateTopGpa() {
	Map<Integer,Optional<Student>> studentMap=	StudentDataBase.getAllStudents()
		.stream()
		.collect(Collectors.groupingBy(Student::getGradeLevel,Collectors.maxBy(Comparator.comparing(Student::getGpa))));
		System.out.println(studentMap);
		//{2=Optional[Student [name=Jenny, gradeLevel=2, gpa=3.8, gender=female, activities=[swimming, gymnastics, soccer], noteBooks=12, bike=Optional.empty]], 3=Optional[Student [name=Emily, gradeLevel=3, gpa=4.0, gender=female, activities=[swimming, gymnastics, aerobics], noteBooks=10, bike=Optional.empty]], 4=Optional[Student [name=James, gradeLevel=4, gpa=3.9, gender=male, activities=[swimming, basketball, baseball, football], noteBooks=14, bike=Optional.empty]]}

	}

	public static void main(String[] args) {
		groupByGender();
		customizeGroupingBy();
		twoLevelGrouping_1();
		threeArgsGroupBy();
		calculateTopGpa();
	}
}
