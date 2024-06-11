package concepts;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Emp{
	int id;
	String name;
	
	
	public Emp(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
//	@Override
//	public int hashCode() {
//		return Objects.hash(id, name);
//	}
	@Override
	public int hashCode() {
		return 123;
	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Emp other = (Emp) obj;
//		return id == other.id && Objects.equals(name, other.name);
//	}
	
	@Override
	public boolean equals(Object obj) {
		return true;
	}
	
	
}



public class HashMapEx {
	

	public static void main(String[] args) {
		
		Emp emp1 = new Emp(1,"abc");
		Emp emp2 = new Emp(2,"abc");
		
		
		Map<Emp,String> hm = new HashMap();
		hm.put(emp1,"s1");
		hm.put(emp2,"s2");
		
		
		System.out.println("HashMap size: "+hm.size());
		
		
	}
	
	

}
