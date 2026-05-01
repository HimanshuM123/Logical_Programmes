package concepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayListStream {
	
	public static void main(String[] args) {
		
		
		Empl e1 = new Empl(1,200);
		Empl e2 = new Empl(2,300);
		Empl e3 = new Empl(3,400);
		List<Empl> al= Arrays.asList(e1,e2,e3);
		
	List<Empl> res=	al.stream().filter(obj -> obj.empId==2000).collect(Collectors.toList());
	
	System.out.println(res.size());//0
		
		
	}

	
	
}

class Empl{
	int id;
	int empId;
	public Empl(int id, int empId) {
		super();
		this.id = id;
		this.empId = empId;
	}
	
	
}