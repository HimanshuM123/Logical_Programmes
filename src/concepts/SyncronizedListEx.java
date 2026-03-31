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
		Thread t1 = new Thread(()->{
			list.add("Cobol");
		});
		
		t1.start();
		List<String> synchronizedList = Collections.synchronizedList(list);
		/*
		Thread t1 = new Thread(()->{
			synchronizedList.add("Cobol");  java.util.ConcurrentModificationException
		});
		
		*/

		for (String obj : synchronizedList) {
			System.out.println(obj + " ");
			//synchronizedList.add("C#");  java.util.ConcurrentModificationException
		}
	}

}

/*
 Java 
Python 
Node 
Cobol 
 
  
 
 */



//java.util.ConcurrentModificationException
/*
Only Synchronized Access, Not Synchronized Iteration: synchronizedList provides 
synchronized access to individual methods like add(), remove(), and get(). However,
 if one thread is iterating over the list and another modifies it, 
the iterator may detect the modification and throw ConcurrentModificationException.
*/