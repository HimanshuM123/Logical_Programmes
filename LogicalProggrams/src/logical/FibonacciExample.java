package logical;

class FibonacciThread extends Thread {
    private int n;
    
    public FibonacciThread(int n) {
        this.n = n;
    }
    
    public void run() {
        System.out.println("Fibonacci of " + n + ": " + fibonacci(n));
    }
    
    private long fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}

public class FibonacciExample {
    public static void main(String[] args) throws InterruptedException {
        int n = 10; // Calculate Fibonacci of numbers from 0 to 9
        for (int i = 0; i < n; i++) {
            new FibonacciThread(i).start();
        }
    }
}
