package concepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Practice extends ArrayList<Integer>{
	
	@Override
	public boolean add(Integer e) {
		if(this.contains(e)) {
			return true;
		}else {
		return super.add(e);
		}
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		
		Practice p = new Practice();
		p.add(1);
		p.add(1);
		p.add(2);
		p.add(2);
		
		System.out.println(p.size());
		
	}
	
	

}


	
