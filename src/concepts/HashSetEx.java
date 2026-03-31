package concepts;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class HashSetEx {
	public static void main(String[] args) {
		Set<Student3> set = new HashSet<>();
		Student3 s1 = new Student3(1,"Ram");
		Student3 s2 = new Student3(2,"Shaym");
		Student3 s3 = new Student3(2,"Rahul");
		set.add(s1);
		set.add(s2);
		set.add(s3);
		System.out.println(set.size());//2
		s3.id=3;
		set.clear();
		set.add(s1);
		set.add(s2);
		set.add(s3);
		System.out.println(set.size());//3
	}
	
	
	

}

class Student3{
	int id ;
	String name;
	
	public Student3(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student3 other = (Student3) obj;
		return id == other.id ;
	}
	
	
	
	
}
