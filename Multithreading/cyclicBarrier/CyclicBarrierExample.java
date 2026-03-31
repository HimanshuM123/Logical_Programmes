package cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    public static void main(String[] args) {
        // Number of threads (workers)
        int numberOfWorkers = 4;

        // CyclicBarrier with a barrier action (executed when all threads reach the barrier)
        CyclicBarrier barrier = new CyclicBarrier(numberOfWorkers, () -> {
            System.out.println("All workers reached the barrier. Proceeding to the next phase...");
        });

        // Creating worker threads
        for (int i = 0; i < numberOfWorkers; i++) {
            Thread worker = new Thread(new Worker1(barrier), "Worker-" + (i + 1));
            worker.start();
        }
    }
}

// Worker class that performs a task in phases
class Worker1 implements Runnable {
    private final CyclicBarrier barrier;

    public Worker1(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            for (int phase = 1; phase <= 3; phase++) { // Simulate 3 phases
                System.out.println(Thread.currentThread().getName() + " is performing phase " + phase);
                Thread.sleep((int) (Math.random() * 1000)); // Simulate task duration

                System.out.println(Thread.currentThread().getName() + " is waiting at the barrier...");
                barrier.await(); // Wait for other threads
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


/*

Description
A CyclicBarrier allows a group of threads to wait for each other to reach 
a common barrier point before proceeding.
Unlike CountDownLatch, it can be reused after the barrier is released.

Key Characteristics
Reusability: After all threads reach the barrier, it resets automatically.
Fixed Number of Threads: The barrier is designed for a specific number of threads.
Common Use Cases
Coordinating phases in iterative computations (e.g., simulations, game turns).
Managing inter-thread dependencies where all threads must reach a checkpoint.


*/


/*

Worker-1 is performing phase 1
Worker-3 is performing phase 1
Worker-2 is performing phase 1
Worker-4 is performing phase 1
Worker-2 is waiting at the barrier...
Worker-1 is waiting at the barrier...
Worker-3 is waiting at the barrier...
Worker-4 is waiting at the barrier...
All workers reached the barrier. Proceeding to the next phase...
Worker-4 is performing phase 2
Worker-1 is performing phase 2
Worker-3 is performing phase 2
Worker-2 is performing phase 2
Worker-1 is waiting at the barrier...
Worker-4 is waiting at the barrier...
Worker-2 is waiting at the barrier...
Worker-3 is waiting at the barrier...
All workers reached the barrier. Proceeding to the next phase...
Worker-3 is performing phase 3
Worker-1 is performing phase 3
Worker-2 is performing phase 3
Worker-4 is performing phase 3
Worker-1 is waiting at the barrier...
Worker-4 is waiting at the barrier...
Worker-3 is waiting at the barrier...
Worker-2 is waiting at the barrier...
All workers reached the barrier. Proceeding to the next phase...


*/