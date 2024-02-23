package printSequence;

public class PrintSeq4 implements Runnable{
	
	 public static void main(String[] args) {
		 
		 PrintSeq4 runnable1=new PrintSeq4(0);
		 PrintSeq4 runnable2=new PrintSeq4(1);
		 PrintSeq4 runnable3=new PrintSeq4(2);
		 PrintSeq4 runnable4=new PrintSeq4(3);
	 
	        Thread t2=new Thread(runnable2,"T2");
	        Thread t3=new Thread(runnable3,"T3");
	        Thread t1=new Thread(runnable1,"T1");
	        Thread t4=new Thread(runnable1,"T4");
	      
	 
	        t1.start();
	        t2.start();
	        t3.start();  
	        t4.start();
	    }
	 
    public int n=10;
    static int  i=1;
    int remainder;
    static Object lock=new Object();
 
    PrintSeq4(int remainder)
    {
        this.remainder=remainder;
    }
 
    @Override
    public void run() {
        while (i < n-1) {
            synchronized (lock) {
            	//System.out.println(">>>>>"+i % 3+" remainder"+remainder);
            //	System.out.println(i % 3 != remainder);
                while (i % 4 != remainder) { // wait for numbers other than remainder
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