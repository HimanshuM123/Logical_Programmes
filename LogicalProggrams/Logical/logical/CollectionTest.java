package logical;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.concurrent.CopyOnWriteArrayList;


public class CollectionTest {
	
	public static void main(String[] args) {
		ArrayList<String> list=new ArrayList<String>();//Creating arraylist    
	      list.add("Mango");//Adding object in arraylist    
	      list.add("Apple");    
	      list.add("Banana");    
	      list.add("Grapes");    
	      //Printing the arraylist object   
	      System.out.println(list);  
	      
	      
	      HashSet<String> set=new HashSet<String>();  
	      set.add("Ravi");  
	      set.add("Vijay");  
	      set.add("Ravi");  
	      set.add("Ajay");  
	      //Traversing elements  
	      Iterator<String> itr=set.iterator();  
	      while(itr.hasNext()){  
	       System.out.println(itr.next());  
	       
	       
	       LinkedHashSet<String> lh=new LinkedHashSet<String>();  
	       lh.add("Ravi");  
	       lh.add("Vijay");  
	       lh.add("Ravi");  
	       lh.add("Ajay");  
	       Iterator<String> itr1=lh.iterator();  
	       while(itr1.hasNext()){  
	        System.out.println(itr1.next()); 
	        
	        HashMap<String, Integer> map = new HashMap<>();  
	        map.put("Aman", 19);  
	        map.put("Sunny", 29);  
	        map.put("Ritesh", 39); 
	        
	        HashMap<Integer,String> lhm=new LinkedHashMap<>();
	        lhm.put(1, "abc");
	        lhm.put(5, "shs");
	        lhm.put(2, "fkfi");
	        
	      
	        
	        CopyOnWriteArrayList<String> lst=new CopyOnWriteArrayList<String>();//Creating arraylist    
		      lst.add("Mango");//Adding object in arraylist    
		      lst.add("Apple");    
		      //Printing the arraylist object   
		      System.out.println(lst); 
	        
	        
	      } 
	      
	}
	}
}

