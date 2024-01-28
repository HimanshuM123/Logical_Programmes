package java8Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class Min_Max {
	
	public static void main(String[] args) {
		Integer [] arr = {3,7,10,9,20};
		List <Employee> employees  = new ArrayList<>();
		
		for(Integer i : arr) {
			Employee emp = new Employee();
			emp.setId(i);
			employees.add(emp);
		}
		
		
		Employee firstEmp = employees.stream()
			      .min((e1, e2) -> e1.getId() - e2.getId())
			      .orElseThrow(NoSuchElementException::new);
		System.out.println("Minimum =>"+firstEmp.getId());
		
		
		 Employee maxSalEmp = employees.stream()
			      .max(Comparator.comparing(Employee::getId))
			      .orElseThrow(NoSuchElementException::new);
		 System.out.println("Maximum =>"+maxSalEmp.getId());
		 

			Employee max = employees.stream()
				      .min((e1, e2) -> e1.getId() + e2.getId())
				      .orElseThrow(NoSuchElementException::new);
			System.out.println("Maximum2 =>"+max.getId());
			
			List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);
			Integer  max_num= 	list.stream().max(Comparator.comparing(a -> a)).get(); //7
			System.out.println(max_num);
			
			Integer  min_num= 	list.stream().min(Comparator.comparing(a -> a)).get(); //1
			System.out.println(min_num);

	}

}
