package futures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {

    // Simulating a method that fetches user details from a service
    public static CompletableFuture<String> fetchUserDetails() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                // Simulate delay (e.g., service call)
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
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
            return "Order details fetched!";
        });
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        // Fetching user details and order details in parallel
        CompletableFuture<String> userFuture = fetchUserDetails();
        CompletableFuture<String> orderFuture = fetchOrderDetails();

        // Combine results of both futures
        CompletableFuture<String> combinedFuture = userFuture.thenCombine(orderFuture, (userDetails, orderDetails) -> {
            return userDetails + " & " + orderDetails;
        });

        // Waiting for the combined future to complete and get the result
        String result = combinedFuture.get();

        System.out.println(result);  // Output: User details fetched! & Order details fetched!
    }
}
