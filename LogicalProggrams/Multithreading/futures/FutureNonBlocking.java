package futures;



import java.util.concurrent.*;

public class FutureNonBlocking {
    public static void main(String[] args) {
        // Run an asynchronous task
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);  // Simulate long-running task
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Task completed!";
        });

        System.out.println("Task submitted, doing other work...");

        // Register a callback to handle the result when it’s ready (non-blocking)
        future.thenAccept(result -> {
            System.out.println("Result: " + result);
        });

        // Do other work without blocking
        System.out.println("Main thread continues without waiting.");

        // Pause the main thread to see async result (for demonstration purposes)
        try {
            Thread.sleep(3000);  // Ensures program waits long enough to see result
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/*

Task submitted, doing other work...
Main thread continues without waiting.
Result: Task completed!

*/