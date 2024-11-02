package concepts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SyncronizedListEx {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("Java");
		list.add("Python");
		list.add("Node");
		List<String> synchronizedList = Collections.synchronizedList(list);

		for (String obj : synchronizedList) {
			System.out.println(obj + " ");
			synchronizedList.add("C#");
		}
	}

}
//java.util.ConcurrentModificationException
/*
Only Synchronized Access, Not Synchronized Iteration: synchronizedList provides 
synchronized access to individual methods like add(), remove(), and get(). However,
 if one thread is iterating over the list and another modifies it, 
the iterator may detect the modification and throw ConcurrentModificationException.
*/