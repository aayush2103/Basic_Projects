package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task implements Runnable{
	
	private int counter;
	
	public Task(int val) {
		this.counter = val;
	}
	
	public void setCounter(int val) {
		this.counter = val;
	}
	
	public int getCounter() {
		return this.counter;
	}
	
	public void incrementCtr() {
		this.counter++;
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" start()"+this.counter);
//		try {
//			Thread.sleep(2000);
//		}
//		catch(InterruptedException e) {
//			e.getMessage();
//		}
		incrementCtr();
		System.out.println("Counter : "+this.counter);
		System.out.println(Thread.currentThread().getName()+" end() ");
	}
}

public class Threadpool2 {
	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(2);
		int count = 3;
		for(int i =0;i<count;i++) {
			Task t = new Task(i);
			pool.execute(t);
		}
		pool.shutdown();
		while(!pool.isTerminated()) {}
		System.out.println("Finished all threads.");
	}
}
