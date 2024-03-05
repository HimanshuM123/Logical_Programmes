package concepts;

@FunctionalInterface
interface Payment {
	void doTransaction();

	default void addCoupon() {// Not forcing User to Override
		System.out.println("Added cashback");
	}

	static void generateTxn() { // common behavior 
		System.out.println("Generated txnId " + Math.random());
	}
}

class GPay implements Payment {

	// Most need to Override
	@Override
	public void doTransaction() {
		System.out.println("doTransaction for  GPay");

	}
	
	//Optional to Override
	public void addCoupon() {
		System.out.println("Added cashback GPay");

	}

}

class Paytm implements Payment {

	// Most need to Override
	@Override
	public void doTransaction() {
		System.out.println("doTransaction for  Paytm");

	}

}

public class InterfaceJava8 {

	public static void main(String[] args) {
		Payment gpay = new GPay();
		gpay.doTransaction();//doTransaction for  GPay
		gpay.addCoupon();//Added cashback GPay

		
		Payment paytm = new Paytm();
		paytm.doTransaction();//doTransaction for  Paytm

		Payment.generateTxn();//Generated txnId 0.42911059309150035
		
		
	}

}
