package threadPool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

class ThreadPool {

	private BlockingQueue<Runnable> blockingQueue;

	// Define size of queue and no of threads
	public ThreadPool(int queueSize, int noOfThreads) {
		blockingQueue = new LinkedBlockingDeque<>(queueSize);
		TaskExecutor taskExecutor = null;
		for (int i = 0; i < noOfThreads; i++) {
			taskExecutor = new TaskExecutor(blockingQueue);
			Thread thread = new Thread(taskExecutor);
			thread.start();
		}
	}

	public void submit(Runnable runnable) {
		blockingQueue.add(runnable);
	}
}

class TaskExecutor implements Runnable {

	private BlockingQueue<Runnable> blockingQueue;

	public TaskExecutor(BlockingQueue<Runnable> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				// take the task from queue and execute
				Runnable runnable = blockingQueue.take();
				runnable.run();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class TestTask implements Runnable {
	String task;
	TestTask(String task){
		this.task = task;
	}
	@Override
	public void run() {
		System.out.println("Running task...");
		
	}
}

public class CustomThreadPool {
	 public static void main(String[] args) {
	        ThreadPool threadPool = new ThreadPool(3,2);
	        for(int taskNumber = 1 ; taskNumber <= 7; taskNumber++) {
	            TestTask testTask1 = new TestTask("abcd_"+taskNumber);
	            threadPool.submit(testTask1);
	        }


	    }
}
