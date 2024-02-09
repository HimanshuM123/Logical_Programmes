package java8.multipleInheritance;

public interface Flyable {
	default void repair() {
    	System.out.println("Repairing Flyable object");	
    }
}
