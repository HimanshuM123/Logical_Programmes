package livelock;

//Implementation of ReadWriteLock in Java 
import java.io.*; 
import java.util.ArrayList; 
import java.util.List; 
import java.util.concurrent.locks.Lock; 
import java.util.concurrent.locks.ReadWriteLock; 
import java.util.concurrent.locks.ReentrantReadWriteLock; 
class ReadWriteLockEx<O> { 

	private final ReadWriteLock readWriteLock 
		= new ReentrantReadWriteLock(); 
	private final Lock writeLock 
		= readWriteLock.writeLock(); 
	private final Lock readLock = readWriteLock.readLock(); 
	private final List<O> list = new ArrayList<>(); 

	// setElement function sets 
	// i.e., write the element to the thread 
	public void setElement(O o) 
	{ 
		// acquire the thread for writing 
		writeLock.lock(); 
		try { 
			list.add(o); 
			System.out.println( 
				"Element by thread "
				+ Thread.currentThread().getName() 
				+ " is added"); 
		} 
		finally { 
			// To unlock the acquired write thread 
			writeLock.unlock(); 
		} 
	} 

	// getElement function prints 
	// i.e., read the element from the thread 
	public O getElement(int i) 
	{ 
		// acquire the thread for reading 
		readLock.lock(); 
		try { 
			System.out.println( 
				"Elements by thread "
				+ Thread.currentThread().getName() 
				+ " is printed"); 
			return list.get(i); 
		} 
		finally { 
			// To unlock the acquired read thread 
			readLock.unlock(); 
		} 
	} 
	public static void main(String[] args) 
	{ 
		ReadWriteLockEx<String> gfg = new ReadWriteLockEx<>(); 

		gfg.setElement("Hi"); 
		gfg.setElement("Hey"); 
		gfg.setElement("Hello"); 

		System.out.println("Printing the last element : "
						+ gfg.getElement(2)); 
	} 
}


/*

Element by thread main is added
Element by thread main is added
Element by thread main is added
Elements by thread main is printed
Printing the last element : Hello



Rules:

Read lock and Write lock which allows a thread to lock the ReadWriteLock either for reading or writing. 

Read lock: If there is no thread that has requested the write lock and the lock for writing, 
then multiple threads can lock the lock for reading. It means multiple threads can read the data at the very moment, 
as long as there’s no thread to write the data or to update the data.

Write Lock: If no threads are writing or reading, only one thread at a moment can lock the lock for writing. 
Other threads have to wait until the lock gets released. It means, only one thread can write the data at the very moment, and other threads have to wait.


*/