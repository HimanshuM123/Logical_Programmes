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
		System.out.println("Minimum =>"+firstEmp.getId());  //Minimum =>3
		
		
		Employee maximum = employees.stream()
			      .min((e1, e2) -> e1.getId() + e2.getId())
			      .orElseThrow(NoSuchElementException::new);
		System.out.println("Maximum =>"+maximum.getId());//Maximum =>20
		
		
		
		 Employee maxSalEmp = employees.stream()
			      .max(Comparator.comparing(Employee::getId))
			      .orElseThrow(NoSuchElementException::new);
		 System.out.println("Maximum =>"+maxSalEmp.getId());//Maximum =>20
		 
			
			List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);
			Integer  max_num= 	list.stream().max(Comparator.comparing(a -> a)).get(); //7
			System.out.println(max_num);
			
			Integer  max_num2= list.stream().max((a,b)-> a -b).get();
			System.out.println("max_num2 "+max_num2);
			
			
			Integer  min_num= 	list.stream().min(Comparator.comparing(a -> a)).get(); //1
			System.out.println(min_num);
			
			Integer  min_num2= list.stream().min((a,b)-> a -b).get();
			System.out.println("min_num2 "+min_num2);

	}

}
