package semaphore;

import java.util.concurrent.Semaphore;

public class Semephore {

	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(3);
		for(int i=0; i< 10; i++) {
			new Thread(new Car(semaphore, "Car-" + i)).start();
		}
	}
}

class Car implements Runnable{
	Semaphore semaphore;
	String carName;

	Car(Semaphore semaphore, String carName) {
		this.semaphore = semaphore;
		this.carName = carName;
	}

	@Override
	public void run() {
		System.out.println("Car..."+carName);
		try {
			Thread.sleep(1000);
			semaphore.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			semaphore.release();
		}
		
	}

}
