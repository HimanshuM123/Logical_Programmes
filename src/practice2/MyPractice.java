package practice2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

public class MyPractice {

	public static void main(String[] args) throws InterruptedException {
		MyTable obj = new MyTable();
		
		Thread t1 = new Thread(()->{
			obj.printTable(1);
		});
		Thread t2 = new Thread(()->{
			obj.printTable(10);
		});
		t1.start();
		t1.join();
		t2.start();
		

	}
}

class MyTable {
	public  void printTable(int x) {
		for (int i = 1; i <= 5; i++) {
			System.out.println(i* x);
		}
	}
}

//The longest substring without repeating is [o, f, t, h, e, d, a, y]
