package immutable;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

class Person {
	private final String name;
	private final Date birthday;
	private final List hobbies;

	public Person(String name, Date birthday, List hobbies) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.hobbies = hobbies;
	}

	public String getName() {
		return name;
	}

	public Date getBirthday() {
		//return birthday;
		return (Date) birthday.clone(); 
	}

	public List getHobbies() {
		return hobbies;
		//return Collections.unmodifiableList(hobbies); 
	}

	@Override
	public String toString() {
		return "person [name=" + name + ", birthday=" + birthday + ", hobbies=" + hobbies + "]";
	}

}

public class ImmutableTest {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		 cal.set(1982, 4, 21);
		 Date birthDate = cal.getTime();

		 List hobbies = new ArrayList<>();
		 hobbies.add("Painting");
		 hobbies.add("Travelling");
		 hobbies.add("Fitness");
		 
		 Person robin=new Person("Robin",birthDate,hobbies);
		 System.out.println("Before");
		 System.out.println(robin);

		 // if it's immutable you can't change the object
		 Date birthday = robin.getBirthday();
		 birthday.setTime(System.currentTimeMillis());

		 List originalHobbies = robin.getHobbies();
		 originalHobbies.remove(0);
		 originalHobbies.remove(0);

		 System.out.println("After");
		 System.out.println(robin); 
	}
	
	 
	 
	 
	 

}
