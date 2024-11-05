package concepts;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteEx {

	public static void main(String[] args) throws InterruptedException {
//		List<Integer> al = new ArrayList<>();
		CopyOnWriteArrayList<Integer> al = new CopyOnWriteArrayList<>();
		al.add(1);
		
		Thread t1 = new Thread(()->{
			al.add(2);
			al.add(3);
			al.add(4);
			//Thread.sleep(50);
			
		});
		
		t1.start();

		for (Integer obj : al) {
			Thread.sleep(5000);
			System.out.println(obj);
		}

	}

}


/*
Only 1 will be printed, as the iterator over the CopyOnWriteArrayList
 does not reflect modifications made after the iteration begins.
*/