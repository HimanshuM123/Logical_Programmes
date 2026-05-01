package java8Stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortedStream {
	public static void main(String[] args) {
		Employee emp1 = new Employee();
		emp1.setName("Mark Zuckerberg");
		Employee emp2 = new Employee();
		emp2.setName("Jeff Bezos");
		Employee emp3 = new Employee();
		emp3.setName("Bill Gates");
		
		List <Employee> employees  = new ArrayList<>();
		
		employees.add(emp1);
		employees.add(emp2);
		employees.add(emp3);
		
		for(Employee obj : employees) {
			System.out.println(obj.getName());
		}
		System.out.println("Sorted by name=================================");
		List<Employee> employees1 = employees.stream()
			      .sorted((e1, e2) -> e1.getName().compareTo(e2.getName()))
			      .collect(Collectors.toList());

		for(Employee obj : employees1) {
			System.out.println(obj.getName());
		}
		
		System.out.println("Sorted by name2=================================");
		List<Employee> employees2 = employees.stream()
			      .sorted(Comparator.comparing(Employee::getName))
			      .collect(Collectors.toList());
		for(Employee obj : employees2) {
			System.out.println(obj.getName());
		}
	}

}
