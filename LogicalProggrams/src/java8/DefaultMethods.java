package java8;

interface Sayable4{  
    // Default method   
    default void say(){  
        System.out.println("Hello, this is default method");  
    }  
    // Abstract method  
    void sayMore(String msg);  
}  
public class DefaultMethods implements Sayable4{  
    public void sayMore(String msg){        // implementing abstract method   
        System.out.println(msg);  
    }  
    
//    public void say(){        // method override  
//        System.out.println("Overriding say method");  
//    }  
    public static void main(String[] args) {  
        DefaultMethods dm = new DefaultMethods();  
        dm.say();   // calling default method  
        dm.sayMore("Work is worship");  // calling abstract method  
  
    }  
}  