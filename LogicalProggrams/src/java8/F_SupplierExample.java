package java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class F_SupplierExample {
	public static void main(String[] args) {
		Supplier<Student> studentSupplier = () -> {
			return new Student("Adam", 2, 3.6, "male", Arrays.asList("swimming", "basketball", "volleyball"));
		};

		Supplier<List<Student>> supplierList = () -> StudentDataBase.getAllStudents();

		System.out.println("The result of supplier is " + studentSupplier.get());
		System.out.println("The student list is " + supplierList.get());
		
		Supplier<String> supp=()->{
			return "supplier";
		};
		System.out.println(supp.get());
	}
}
