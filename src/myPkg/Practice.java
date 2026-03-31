package myPkg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

public class Practice {

	public static void main(String[] args) {
		Practice p = new Practice();
		Thread t1 = new Thread(() -> {
			p.printEvenOdd(0);
		}

		);
		Thread t2 = new Thread(() -> {
			p.printEvenOdd(1);
		}

		);
		
		t1.start();
		t2.start();

	}

	int limit =20;
	int i=0;
	
	Object lock = new Object();
	private void printEvenOdd(int num)  {
		
		while(i <limit) {
			
			synchronized (lock) {
				if(i %2==num) {
					System.out.println(i+"   "+Thread.currentThread());
					i++;
					
						lock.notifyAll();
					
				}else {
					System.out.println(i+"   "+Thread.currentThread());
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				
			}
			
			
			
		}

	}

}
