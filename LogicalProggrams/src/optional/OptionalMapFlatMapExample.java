package optional;


import java.util.Optional;

import java8.Student;
import java8.StudentDataBase;

public class OptionalMapFlatMapExample {

    public static void optionalFlatMap(){
      Optional<Student> studentOptional =  Optional.ofNullable(StudentDataBase.studentSupplier.get());
      
      Optional<String> name=studentOptional
    		  .filter(student -> student.getGpa()>=3.5)//Optional<Student<Optional<Bike>>
    		  .flatMap(Student::getBike)//Optional<Bike>
    		  .map(Bike::getName);
      
      name.ifPresent(s -> System.out.println("name :"+s));
    }

    public static void optionalMap(){
    	Optional<Student> studentOptional =  Optional.ofNullable(StudentDataBase.studentSupplier.get());
    	if(studentOptional.isPresent()) {
    		Optional<String> stringOptional=studentOptional
    				.filter(s -> s.getGpa()>=3.5)
    				.map(Student::getName);
    				System.out.println(stringOptional.get());
    	}
    }

    public static void optionalFilter(){

    	Optional<Student> studentOptional =  Optional.ofNullable(StudentDataBase.studentSupplier.get());
    	studentOptional.filter(student -> student.getGpa()>=3.5)
    	.ifPresent(student -> System.out.println(student));
    }

    public static void main(String[] args) {
        optionalFlatMap();
        optionalMap();
        optionalFilter();
    }
}