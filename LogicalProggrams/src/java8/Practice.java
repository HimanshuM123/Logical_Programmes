package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import java8Stream.Employee;

public class Practice {
	
	public static void main(String[] args) {
		Job j1 = new Job(3,"Developer");
		Job j2 = new Job(1,"Tester");
		Job j3 = new Job(2,"Support");
		
	
	List<Job> list = new ArrayList<>();
	list.add(j1);
	list.add(j2);
	list.add(j3);
	
	Collections.sort(list);
	
	for(Job j : list) {
		System.out.println(j.getTitle());
	}
		
	}

}


class Job  implements Comparable<Job>{
	
	
	public Job(int id, String title) {
		super();
		this.id = id;
		this.title = title;
	}
	private int id;
	private String title;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public int compareTo(Job o) {
		return (this.title.compareTo(o.title));
		
	}
	
	
}
