package java8;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

class Student1{
	private String name;
	private int marks;
	
	public Student1(String name, int marks) {
		this.name=name;
		this.marks= marks;
	}
	public void show() {
		System.out.println(this.name+" "+this.marks);
	}
	
	public void takeIn(String s) {
		System.out.println(this.name+ s);
	}
	public String retrive() {
		return "SK";
	}
}

public class MethodReferenceType {
	public static void main(String[] args) {
		//Unbounded method reference
		Consumer <Student1> lambda1 = s-> s.show();
		Consumer<Student1> mr1 = Student1::show;
		
		lambda1.accept(new Student1("S1", 34));
		mr1.accept(new Student1("S1", 34));

		Function<String, String> upperL = s -> s.toUpperCase();
		Function<String, String> upperMR = String::toUpperCase;
		System.out.println(upperL.apply("abc"));
		System.out.println(upperMR.apply("xyz"));
		
		BiFunction<String, String, String> bf = (s1,s2) -> s1.concat(s2);
		System.out.println(bf.apply("Fruit ->", "Mango"));
		
		BiFunction<String, String, String> bf2 = String::concat;
		System.out.println(bf2.apply("Fruit->", "Orange"));
		
		//Bounded method reference
		Student1 s3= new Student1("S3", 85);
		
		Supplier<String> lambda2 = ()-> s3.retrive();
		Supplier<String> mr2 =  s3::retrive;
		System.out.println(lambda2.get());
		System.out.println(mr2.get());
		
		
		BiConsumer<Student1, String> bicLambda= (student,str) -> student.takeIn(str);
		BiConsumer<Student1, String> bicMr= Student1::takeIn;
		bicLambda.accept(new Student1("S5", 54), "lecturer1");
		bicMr.accept(new Student1("S5", 54), "lecturer1");
		
	}
	

}
