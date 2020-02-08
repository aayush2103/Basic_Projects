package threads;

public class DaemonThread extends Thread {
	public DaemonThread(String name) {
		super(name);
	}
	@Override
	public void run() {
		if(Thread.currentThread().isDaemon())
			System.out.println(getName()+" is Daemon Thread.");
		else
			System.out.println(getName()+" is User Thread.");
	}
	public static void main(String[] args) {
		DaemonThread d1 = new DaemonThread("thread1");
		DaemonThread d2 = new DaemonThread("thread2");
		DaemonThread d3 = new DaemonThread("thread3");
		
		d1.setDaemon(true);
		d1.start();
		
		d2.start();
		
		d3.setDaemon(true);
		d3.start();
	}
}
