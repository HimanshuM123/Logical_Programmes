package java8Stream;

import java.util.ArrayList;
import java.util.List;

public class Reduction {
public static void main(String[] args) {
	Double [] arr = {30.0,76.8,53.9};
	List <Employee> employees  = new ArrayList<>();
	
	for(Double salary : arr) {
		Employee emp = new Employee();
		emp.setSalary(salary);
		employees.add(emp);
	}
	
    Double sumSal = employees.stream()
    	      .map(Employee::getSalary)
    	      .reduce(0.0, Double::sum);
    System.out.println(sumSal);
	
}
}
