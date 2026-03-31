package logical;

class FactorialThread extends Thread {
    private final int start;
    private final int end;
    private long result = 1;

    public FactorialThread(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public void run() {
        for (int i = start; i <= end; i++) {
            result *= i;
        }
    }

    public long getResult() {
        return result;
    }
}

public class Factorial {
    public static void main(String[] args) throws InterruptedException {
        int n = 10;  // For calculating factorial of 10
        FactorialThread t1 = new FactorialThread(1, n / 2);
        FactorialThread t2 = new FactorialThread(n / 2 + 1, n);
        
        t1.start();
        t2.start();
        
        t1.join();
        t2.join();
        
        long factorial = t1.getResult() * t2.getResult();
        System.out.println("Factorial of " + n + " is: " + factorial);
    }
}
