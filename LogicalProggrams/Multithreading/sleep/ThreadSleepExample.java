package sleep;

public class ThreadSleepExample extends Thread {
	
	@Override
	public void run() {
		for(int i=0;i<5 ;i++) {
			try {
				System.out.println(i);
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	public static void main(String[] args) {
		ThreadSleepExample obj1 = new ThreadSleepExample();
		ThreadSleepExample obj2 = new ThreadSleepExample();
		obj1.start();
		obj2.start();
		
	}
}
/*
0
0
1
1
2
2
3
3
4
4

*/