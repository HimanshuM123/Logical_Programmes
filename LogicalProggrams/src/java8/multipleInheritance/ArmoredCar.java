package java8.multipleInheritance;

public class ArmoredCar implements Floatable, Flyable {

//	@Override
//	public void repair() {
//		// TODO Auto-generated method stub
//		Flyable.super.repair();
//	}

	@Override
	public void repair() {
		// TODO Auto-generated method stub
		Floatable.super.repair();
	}
	
	//Either one of the method needs to be Overridden
	

}
