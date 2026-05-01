package java8.multipleInheritance;

public interface Floatable {
    default void repair() {
    	System.out.println("Repairing Floatable object");	
    }
}