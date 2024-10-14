package threadLocal;

public class ThreadLocalExample {

    // Creating a ThreadLocal variable
    private static ThreadLocal<Integer> threadLocalValue = ThreadLocal.withInitial(() -> 0);

    public static void main(String[] args) throws InterruptedException {

        // Creating thread 1
        Thread thread1 = new Thread(() -> {
            // Setting thread-local value for thread 1
            threadLocalValue.set(100);
            System.out.println("Thread 1 initial value: " + threadLocalValue.get());
            
            try {
                Thread.sleep(2000); // Simulating some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Retrieving thread-local value in thread 1
            System.out.println("Thread 1 final value: " + threadLocalValue.get());
        });

        // Creating thread 2
        Thread thread2 = new Thread(() -> {
            // Setting thread-local value for thread 2
            threadLocalValue.set(200);
            System.out.println("Thread 2 initial value: " + threadLocalValue.get());
            
            try {
                Thread.sleep(1000); // Simulating some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Retrieving thread-local value in thread 2
            System.out.println("Thread 2 final value: " + threadLocalValue.get());
        });

        thread1.start();
        thread2.start();

        // Wait for both threads to finish
        thread1.join();
        thread2.join();

        // Main thread value
        System.out.println("Main thread value: " + threadLocalValue.get());
    }
}
/*
 * 
 * Thread 1 initial value: 100
Thread 2 initial value: 200
Thread 2 final value: 200
Thread 1 final value: 100
Main thread value: 0

Explanation:
Each thread gets its own independent copy of the variable initialized via ThreadLocal.withInitial().
Thread 1 sets and accesses its own value, and so does Thread 2.
The main thread also has its own copy of the ThreadLocal variable, which remains as the initial value 0.
*
*/
