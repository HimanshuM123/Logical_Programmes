package practice2;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class JavaStream {
	public static void main(String[] args) {
		Employee e1 = new Employee("Tom", 4000);
		Employee e2 = new Employee("Rob", 2000);
		Employee e3 = new Employee("Nick", 1000);
		Employee e4 = new Employee("Mike", 10000);
		List<Employee> empList = Arrays.asList(e1,e2,e3,e4);
		
	List<Employee> rl=	empList.stream().filter( e -> e.getSalary()>3000).collect(Collectors.toList());
	rl.stream().map(obj -> obj.getName()).forEach(System.out::println);
	
	//average salary
	
	OptionalDouble avg = rl.stream().map(Employee::getSalary).mapToInt(Integer::intValue).average();
	
	System.out.println("The avarage value is "+avg);

	}
}

class Employee {
	String name;
	int salary;

	Employee(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}

	int getSalary() {
		return salary;
	}

	String getName() {
		return name;
	}
}
