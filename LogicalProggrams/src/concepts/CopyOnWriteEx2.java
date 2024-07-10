package concepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class CopyOnWriteEx2 {

	public static void main(String[] args) throws InterruptedException {

		CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList();

		list.add(10);
		list.add(20);

		Iterator itr = list.iterator();
		while (itr.hasNext()) {
			//This won't get added
			list.add(30); // added to the copy of list
			//note : in the case of concurrentHashMap its not added to copy instead the locking is applied on bucket level
			System.out.println(itr.next());
		}

	}
}

/*
10
20
*/

/*

 public boolean add(E e) {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            Object[] elements = getArray();
            int len = elements.length;
            Object[] newElements = Arrays.copyOf(elements, len + 1);
            newElements[len] = e;
            setArray(newElements);
            return true;
        } finally {
            lock.unlock();
        }
    }

Copy-on-Write Semantics: Whenever a modification operation (add, set, remove, etc.) is performed 
on the CopyOnWriteArrayList, it creates a new copy of the underlying array. The modification is applied to 
this new copy while the original array remains unchanged. This approach ensures that existing readers
 (threads accessing the list for reading) are not affected by the modification and can continue to use the original array.
*/