package volatiletest;


public class VolatileTest {
    private static volatile boolean stopThread = false;

    public static void main(String[] args) throws InterruptedException {
        Thread workerThread = new Thread(() -> {
            while (!stopThread) {
                System.out.println("Working...");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Thread stopped.");
        });

        workerThread.start();

        // Main thread sleeps for 2 seconds, then stops the worker thread
        Thread.sleep(2000);
        stopThread = true; // This update is visible to the worker thread
        System.out.println("Stop signal sent.");
    }
}
