package printSequence;

public class PrintSequenceRunnable implements Runnable{
	 
    public int n=10;
    static int  i=1;
    int remainder;
    static Object lock=new Object();
 
    PrintSequenceRunnable(int remainder)
    {
        this.remainder=remainder;
    }
 
    @Override
    public void run() {
        while (i < n-1) {
            synchronized (lock) {
            	//System.out.println(">>>>>"+i % 3+" remainder"+remainder);
            //	System.out.println(i % 3 != remainder);
                while (i % 3 != remainder) { // wait for numbers other than remainder
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " " + i);
                i++;
                lock.notifyAll();
            }
        }
    }
}