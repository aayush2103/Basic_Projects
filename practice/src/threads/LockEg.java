package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

class UploadResultLock implements Runnable{
	private ReentrantLock lock;
	private int result;
	
	public UploadResultLock(ReentrantLock lock) {
		this.lock = lock;
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" start() "+result);
		try {
			lock.lock();
			Thread.sleep(2000);
			result++;
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		finally {
			lock.unlock();
		}
		System.out.println(Thread.currentThread().getName()+" end() "+result);
	}
}

public class LockEg {
	public static void main(String[] args) {
		ExecutorService exSer = Executors.newFixedThreadPool(2);
		ReentrantLock lock = new ReentrantLock();
		int tasks = 3;
		UploadResultLock l1 = new UploadResultLock(lock);
		for(int i = 0;i<tasks;i++) {
			exSer.execute(l1);
		}
		exSer.shutdown();
		while(!exSer.isTerminated()) {}
		System.out.println("Finished all threads.");
	}
}
