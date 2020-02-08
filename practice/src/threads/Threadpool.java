package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//class Tp1 extends Thread{
class Tp1 implements Runnable{
	public String name;
	
	public Tp1(String name) {
		this.name = name;
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" start() "+this.name);
		try {
			Thread.sleep(2000);
		}
		catch(InterruptedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(Thread.currentThread().getName()+" end() "+this.name);
	}
}

public class Threadpool {
	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(2);
		int tasks = 3;
		for(int i =0;i<tasks;i++) {
			Tp1 thread = new Tp1("UserThread : "+i);
			pool.execute(thread);
		}
		pool.shutdown();
		while(!pool.isTerminated()) {}
		System.out.println("Finished All Threads.");
	}
}
