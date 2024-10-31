package futures;



import java.util.concurrent.*;

public class FutureBlocking {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        
        // Submit a task that will run asynchronously
        Future<String> future = executor.submit(() -> {
            Thread.sleep(2000);  // Simulate long-running task
            return "Task completed!";
        });
        
        System.out.println("Task submitted, doing other work...");

        try {
            // Synchronous (blocking) call to retrieve the result
            String result = future.get();  // This blocks until the task is complete
            System.out.println("Result: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}


/*

Task submitted, doing other work...
Result: Task completed!


*/