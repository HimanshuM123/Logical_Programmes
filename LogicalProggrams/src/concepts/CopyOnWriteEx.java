package concepts;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteEx {

	public static void main(String[] args) throws InterruptedException {
//		List<Integer> al = new ArrayList<>();
		List<Integer> al = new CopyOnWriteArrayList<>();
		al.add(1);
		
		Thread t1 = new Thread(()->{
			try {
				al.add(2);
				al.add(3);
				al.add(4);
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		});
		
		t1.start();

		for (Integer obj : al) {
			Thread.sleep(3000);
			System.out.println(obj);
		}

	}

}
