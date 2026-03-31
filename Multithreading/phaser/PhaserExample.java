package phaser;

import java.util.concurrent.Phaser;

public class PhaserExample {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(1); // Register the main thread

        for (int i = 0; i < 3; i++) {
            phaser.register();
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " completed Phase 1.");
                phaser.arriveAndAwaitAdvance(); // Wait for all threads to complete Phase 1

                System.out.println(Thread.currentThread().getName() + " completed Phase 2.");
                phaser.arriveAndAwaitAdvance(); // Wait for all threads to complete Phase 2
            }).start();
        }

        // Main thread waits for all phases
        phaser.arriveAndAwaitAdvance(); // Phase 1
        phaser.arriveAndAwaitAdvance(); // Phase 2
        System.out.println("All phases completed. Proceeding...");
    }
}


/*

Thread-0 completed Phase 1.
Thread-1 completed Phase 1.
Thread-2 completed Phase 1.
Thread-2 completed Phase 2.
Thread-1 completed Phase 2.
Thread-0 completed Phase 2.
All phases completed. Proceeding...


Description
A Phaser is a more flexible and advanced synchronization utility that supports dynamic thread registration and multiple phases.
Threads can register or deregister at any phase, and the phaser tracks phase completions.
Key Characteristics
Dynamic Thread Management: Threads can register and deregister dynamically.
Multi-Phase Coordination: Ideal for workflows with multiple stages or checkpoints.
Common Use Cases
Coordinating multiple phases of tasks where the number of threads may vary.
Handling scenarios like file processing in stages (e.g., read, process, write).


*/