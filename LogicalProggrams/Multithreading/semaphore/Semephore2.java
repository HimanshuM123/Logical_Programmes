package semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

class Downloader {

	private Semaphore semaphore = new Semaphore(3, true);

	public void downloadData() {
		try {
			semaphore.acquire();
			download();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaphore.release();
		}
	}

	public void download() {
		System.out.println("Downloading data from web..." + Thread.currentThread().getName());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

public class Semephore2 {

	public static void main(String[] args) {
		Downloader downLoad = new Downloader();
		ExecutorService executorService = Executors.newCachedThreadPool();

		for (int i = 0; i < 12; i++) {
			executorService.execute(new Runnable() {
				@Override
				public void run() {
					downLoad.downloadData();

				}
			});
		}

	}

}
/*
 * 
 * 
 * Downloading data from web...pool-1-thread-10 Downloading data from
 * web...pool-1-thread-11 Downloading data from web...pool-1-thread-5
 * Downloading data from web...pool-1-thread-12 Downloading data from
 * web...pool-1-thread-9 Downloading data from web...pool-1-thread-8 Downloading
 * data from web...pool-1-thread-7 Downloading data from web...pool-1-thread-3
 * Downloading data from web...pool-1-thread-2 Downloading data from
 * web...pool-1-thread-1 Downloading data from web...pool-1-thread-6 Downloading
 * data from web...pool-1-thread-4
 * 
 * 
 */