package java8;

import java.util.Optional;

public class Person {
	String name;
	Address address;
	public Person(String name, Address address) {
		super();
		this.name = name;
		this.address = address;
	}
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public static void main(String[] args) {
		Country country=new Country("India");
		country=null;
		Address address=new Address(country);
		//address=null;
		Person person=new Person("abc",address);
		
		/*
		 * String countryName=person.getAddress().getCountry().getName();
		 * System.out.println(countryName);
		 */
		
		String countryName2=Optional.ofNullable(person).map(Person::getAddress)
				.map(Address::getCountry).map(Country::getName).orElse(null);
		
		System.out.println(countryName2);
	}
	

}
