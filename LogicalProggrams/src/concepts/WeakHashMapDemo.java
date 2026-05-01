package concepts;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

class WeakHashMapDemo
{
    public static void main(String args[])throws Exception
    {
        WeakHashMap hm = new WeakHashMap();
   //     Map hm = new HashMap();
        Demo d = new Demo();
         
        // puts an entry into WeakHashMap
        hm.put(d," Hi "); 
        System.out.println(hm);
         
        d = null;
         
        // garbage collector is called
        System.gc(); 
         
        // thread sleeps for 4 sec
        Thread.sleep(4000); 
         
        System.out.println(hm);
    }
}


class Demo
{
   public String toString()
   {
       return "demo";
   }
    
   // finalize method
   public void finalize()
   {
       System.out.println("finalize method is called");
   }
}
/*
{demo= Hi }
finalize method is called
{}


*/