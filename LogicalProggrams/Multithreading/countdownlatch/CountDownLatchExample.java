package countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        int threadCount = 3;
        CountDownLatch latch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " finished task.");
                } finally {
                    latch.countDown();
                }
            }).start();
        }

        // Main thread waits until the latch reaches zero
        latch.await();
        System.out.println("All tasks are completed. Proceeding...");
    }
}

/*
Thread-1 finished task.
Thread-0 finished task.
Thread-2 finished task.
All tasks are completed. Proceeding...


============================================================

Description
A CountDownLatch allows one or more threads to wait until a set of operations being performed 
in other threads completes.
The latch is initialized with a count, and threads call countDown() to decrement the count. 
When the count reaches zero, the waiting thread(s) proceed.

Key Characteristics
One-Time Use: Once the count reaches zero, it cannot be reset.
Thread-Independent: Threads decrement the latch, but any waiting thread(s) are not bound to specific threads.
Common Use Cases
Ensuring a set of threads complete their tasks before proceeding.
Coordinating startup tasks in an application (e.g., waiting for services to initialize).
*/