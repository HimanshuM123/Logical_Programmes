package optional;


import java.util.Optional;

import java8.Student;

public class OptionalOrElseExample {


    public static String optionalOrElse(){

        //Optional<Student> getOptionalStudent = Optional.ofNullable(StudentDataBase.studentSupplier.get());
        Optional<Student> optionalStudent = Optional.ofNullable(null);

        String name =  optionalStudent.map(Student::getName).orElse("Default");

        return name;

    }

    public static String optionalOrElseGet(){

        //Optional<Student> getOptionalStudent = Optional.ofNullable(StudentDataBase.studentSupplier.get());
        Optional<Student> optionalStudent = Optional.ofNullable(null);

        String name =  optionalStudent.map(Student::getName).orElseGet(()->"Default");//gets supplier

        return name;

    }

    public static String optionalOrElseThrow(){

        //Optional<Student> getOptionalStudent = Optional.ofNullable(StudentDataBase.studentSupplier.get());
        Optional<Student> optionalStudent = Optional.ofNullable(null);

        String name =  optionalStudent.map(Student::getName).orElseThrow(()->new RuntimeException("No Data available"));

        return name;

    }

    public static void main(String[] args) {


        System.out.println(optionalOrElse());
        System.out.println(optionalOrElseGet());
        System.out.println(optionalOrElseThrow());
    }
}