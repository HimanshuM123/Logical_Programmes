package printSequence;

public class PrintCharacters {
		
	    private static final String str = "abcdefghij";
	    private static final Object lock = new Object();
	    private static int index = 0;

	    public static void main(String[] args) {
	        Thread evenThread = new Thread(() -> printCharacters(0));
	        Thread oddThread = new Thread(() -> printCharacters(1));

	        evenThread.start();
	        oddThread.start();
	    }

	    private static void printCharacters(int threadIndex) {
	        while (index < str.length()) {
	            synchronized (lock) {
	                if (index % 2 == threadIndex) {
	                    System.out.println(Thread.currentThread()+"  "+str.charAt(index));
	                    index++;
	                    lock.notify(); // Notify the other thread
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

