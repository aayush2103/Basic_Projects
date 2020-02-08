package threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task2 implements Callable<Integer>{
	private int counter;
	private String taskName;
	
	public Task2(String name, int c) {
		this.taskName = name;
		this.counter = c;
	}
	@Override
	public Integer call() throws Exception{
		System.out.println(Thread.currentThread().getName()+" start() "+this.taskName);
		try {
			Thread.sleep(2000);
			incrementCounter();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		//System.out.println("Counter : "+this.counter);
		System.out.println(Thread.currentThread().getName()+" end() "+this.taskName);
		return this.counter;
	}
	
	public void incrementCounter() {
		this.counter++;
	}
}
public class CallableFuture2 {
	public static void main(String[] args) {
		ExecutorService exser = Executors.newFixedThreadPool(2);
		Task2 t1 = new Task2("Batch 1", 10);
		Task2 t2 = new Task2("Batch 2", 20);
		Task2 t3 = new Task2("Batch 3", 30);
		List<Task2> tasks = new ArrayList<>();
		tasks.add(t1);
		tasks.add(t2);
		tasks.add(t3);
		try {
			exser.invokeAll(tasks);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		exser.shutdown();
	}
}
