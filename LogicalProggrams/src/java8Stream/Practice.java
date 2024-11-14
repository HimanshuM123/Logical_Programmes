package java8Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Practice {
	public static void main(String[] args) {
		Employee e1 = new Employee("Suresh",2,900.0);
		Employee e2 = new Employee("Ramesh",1,700.0);
		Employee e3 = new Employee("Nikita",3,400.0);
		Employee e4 = new Employee("Rahul",4,200.0);
		
		List<Employee> list = Arrays.asList(e1,e2,e3,e4);
		
	Stream<Employee> stm=	list.stream();
	System.out.println(stm);

	}

}