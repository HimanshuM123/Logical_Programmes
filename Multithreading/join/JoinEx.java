package join;



public class JoinEx {

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

/*

The join() method in Java is provided by the java.lang.Thread class that permits one thread to wait until the other thread to finish its execution.
 Suppose th be the object the class Thread whose thread is doing its execution currently, then the th.join(); statement ensures that th is finished
  before the program does the execution of the next statement. When there are more than one thread invoking the join() method, then it leads 
  to overloading on the join() method that permits the developer or programmer to mention the waiting period. However, similar to the sleep()
   method in Java, the join() method is also dependent on the operating system for the timing, so we should not assume that the join()
    method waits equal to the time we mention in the parameters. The following are the three overloaded join() methods.

Description of The Overloaded join() Method
join(): When the join() method is invoked, the current thread stops its execution and the thread goes into the wait state. 
The current thread remains in the wait state until the thread on which the join() method is invoked has achieved its dead state. 
If interruption of the thread occurs, then it throws the InterruptedException.

*/