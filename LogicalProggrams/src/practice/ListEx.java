package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ListEx {
	public static void main(String[] args) {
		List<String> al = Arrays.asList("Mango","Orange","Banana","Apple");
		
//		Iterator itr = al.iterator();
//		while(itr.hasNext()) {
//			System.out.println(itr.next());
//		}
		
		 Collections.sort(al);
		 
			for(String o : al) {
				System.out.println(o);
			}
		 
	}
}
