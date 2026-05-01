package concepts;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CustomHashMap {
	public static void main(String[] args) {
		Student s1 = new Student(1, "Suresh");
		Student s2 = new Student(1, "Suresh");
		Map<Student, Integer> hm = new HashMap<>();
		hm.put(s1, 1);
		hm.put(s2, 2);
		System.out.println(hm.size()); //  2 ..if hashCode () & equals() not overriden
	//  1 ..if hashCode () & equals()  overriden
		
		
		
		
	}

}

class Student {
	int rollNo;
	String name;
	public Student(int rollNo, String name) {
		super();
		this.rollNo = rollNo;
		this.name = name;
	}
	@Override
	public int hashCode() {
		return Objects.hash(name, rollNo);
		//return 100;
		//hm.size() = 2 if two object are different
		//like 
//		Student s1 = new Student(1, "Suresh");
//		Student s2 = new Student(2, "Suresh");
		
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(name, other.name) && rollNo == other.rollNo;
	}
	
}
