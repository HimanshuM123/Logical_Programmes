package printSequence;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrintSeq2 {


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        final AtomicInteger atomicInteger = new AtomicInteger(1);
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(4);
//        final CyclicBarrier cyclicBarrier = new CyclicBarrier(4, ()-> {
//            System.out.println("a cycle done");
//        });

        IntStream.rangeClosed(0, 3)
                .boxed()
                .map(i -> new PrintSequenceTask(i, atomicInteger, cyclicBarrier))
                .map(p -> executorService.submit(p))
                .collect(Collectors.toList());

        executorService.shutdown();

    }
}


class PrintSequenceTask implements Runnable {
    private final int index;
    private final AtomicInteger atomicInteger;
    private final CyclicBarrier cyclicBarrier;

    PrintSequenceTask(int index, AtomicInteger atomicInteger, CyclicBarrier cyclicBarrier) {
        this.index = index;
        this.atomicInteger = atomicInteger;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run(){
        for(int i=1; i<4;i++){
            while (((atomicInteger.get()-index-1)%4 != 0)){}
            System.out.println(Thread.currentThread().getName()+" "+(atomicInteger.get())+" index "+index);
            atomicInteger.getAndIncrement();
            await();
        }
    }

    public void await(){
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

