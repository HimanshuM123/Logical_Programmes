package livelock;

public class DeadLock2 {
	public static void main(String[] args) {
		final String resource1 = "resource1";
		final String resource2 = "resource2";
		
		Thread t1 = new Thread(()->{
			synchronized (resource1) {
				System.out.println("Thread1 : locked resource1");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				synchronized (resource2) {
					System.out.println("Thread1 : locked resource2");
				}
			}
		});
		
		Thread t2 = new Thread(()->{
//			synchronized (resource1) {
				synchronized (resource2) {
				System.out.println("Thread2 : locked resource2");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
//				synchronized (resource2) {
					synchronized (resource1) {
					System.out.println("Thread2 : locked resource1");
				}
			}
		});
		
		t1.start();
		t2.start();
	}

}
