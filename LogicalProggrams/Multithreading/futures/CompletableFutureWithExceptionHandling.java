package futures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureWithExceptionHandling {

    // Simulating a method that fetches user details from a service
    public static CompletableFuture<String> fetchUserDetails() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                // Simulate delay (e.g., service call)
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }

            // Simulate an error
            if (Math.random() > 0.5) {
                throw new RuntimeException("Failed to fetch user details");
            }

            return "User details fetched!";
        });
    }

    // Simulating a method that fetches order details from another service
    public static CompletableFuture<String> fetchOrderDetails() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                // Simulate delay (e.g., service call)
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }

            // Simulate an error
            if (Math.random() > 0.5) {
                throw new RuntimeException("Failed to fetch order details");
            }

            return "Order details fetched!";
        });
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        // Fetching user details and order details in parallel with exception handling
        CompletableFuture<String> userFuture = fetchUserDetails().exceptionally(ex -> {
            System.out.println("Exception in fetching user details: " + ex.getMessage());
            return "Default User";  // Returning a default value in case of failure
        });

        CompletableFuture<String> orderFuture = fetchOrderDetails().exceptionally(ex -> {
            System.out.println("Exception in fetching order details: " + ex.getMessage());
            return "Default Order";  // Returning a default value in case of failure
        });

        // Combine results of both futures
        CompletableFuture<String> combinedFuture = userFuture.thenCombine(orderFuture, (userDetails, orderDetails) -> {
            return userDetails + " & " + orderDetails;
        });

        // Waiting for the combined future to complete and get the result
        String result = combinedFuture.get();

        System.out.println(result);  // Output: Either fetched details or default values
    }
}

/*

Exception in fetching user details: java.lang.RuntimeException: Failed to fetch user details
Default User & Order details fetched!

*/