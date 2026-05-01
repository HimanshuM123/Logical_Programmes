package java8Stream;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {
public static void main(String[] args) {
	Employee emp1 = new Employee("Joe", 1, 700.0);
	Employee emp2 = new Employee("Paul", 2, 800.0);
	Employee emp3 = new Employee("Bobby", 3, 200.0);
	Employee emp4 = new Employee("Alan", 4, 300.0);

	Map<Integer, Employee> hm = new HashMap<>();
	hm.put(1, emp1);
	hm.put(2, emp2);
	hm.put(3, emp3);
	hm.put(4, emp4);
	
	// Employee with salary greater than 500
	
	List<Map.Entry<Integer,Employee>>  list =hm.entrySet().stream().filter(obj -> obj.getValue().getSalary() > 500).collect(Collectors.toList());
	
	for(Map.Entry<Integer, Employee> o : list) {
		System.out.println(o.getKey());
	}
}
}
