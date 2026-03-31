package printSequence;

public class PrintCharacters2 {
	

	    private static final String str = "abcdefghij";
	    private static final Object lock = new Object();
	    private static int index = 0;

	    public static void main(String[] args) {
	        Thread thread0 = new Thread(() -> printCharacters(0));
	        Thread thread1 = new Thread(() -> printCharacters(1));
	        Thread thread2 = new Thread(() -> printCharacters(2));

	        thread0.start();
	        thread1.start();
	        thread2.start();
	    }

	    private static void printCharacters(int threadIndex) {
	        while (index < str.length()) {
	            synchronized (lock) {
	                if (index % 3 == threadIndex) {
	                	 System.out.println(Thread.currentThread()+"  "+str.charAt(index));
	                    index++;
	                    lock.notifyAll(); // Notify all threads to re-check the condition
	                } else {
	                    try {
	                        lock.wait(); // Wait until it's this thread's turn
	                    } catch (InterruptedException e) {
	                        Thread.currentThread().interrupt();
	                    }
	                }
	            }
	        }
	    }
	}



