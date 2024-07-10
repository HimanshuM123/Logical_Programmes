package concepts;

import java.util.HashMap;
import java.util.Objects;

public class HashMapHashCodeOnly {
	
	public static void main(String args[]) {
		Employee emp1 = new Employee("One");
		Employee emp2 = new Employee("One");

		HashMap<Employee, String> hm = new HashMap<Employee, String>();

		hm.put(emp1, "One");
		hm.put(emp2, "Two");
		
		System.out.println("Both Objects are Equal: "+emp1.equals(emp2));
		System.out.println("Employee 1 Hashcode: "+emp1.hashCode());
		System.out.println("Employee 2 Hashcode: "+emp2.hashCode());
		hm.forEach((k, v) -> System.out.println("Key is: " + k + " Value is: " + v));
		System.out.println("Size "+hm.size());
	}

}


class Employee{
	String name;
	Employee(String name){
		this.name= name;
	}
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Employee other = (Employee) obj;
//		return Objects.equals(name, other.name);
//	}
	
	
	
}