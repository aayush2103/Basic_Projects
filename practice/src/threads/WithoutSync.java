package threads;

class DataContainer{
	private int intData;
	//public synchronized int getData() {
	public int getData() {
		return this.intData;
	}
	
	//public synchronized void setData(int data) {
	public void setData(int data) {
		this.intData=data;
	}
}
class Producer extends Thread{
	private int count=0;
	DataContainer dc= new DataContainer();
	@Override
	public void run() {
		dc.setData(count++);
		System.out.println("Count set to : "+count);
	}
}
class Consumer extends Thread{
	DataContainer dc = new DataContainer();
	@Override
	public void run() {;
		System.out.println(dc.getData());
	}
}
public class WithoutSync {
	public static void main(String[] args) {
		Producer p = new Producer();
		Consumer c = new Consumer();
		p.start();
		c.start();
	}
}
