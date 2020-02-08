package threads;

//Multithreading
class A extends Thread{
	@Override
	public void run() {
		System.out.println("Hello threads");
	}
}

public class ThreadImplementation {
	public static void main(String[] args) throws InterruptedException{
//		for(int i=0; i<5; i++) {
//			A obj = new A();
//			obj.start();
//		}
		
		System.out.println("Main thread starts.");
		A obj = new A();
		obj.start();
		System.out.println(obj.isAlive());
		obj.join();
		System.out.println(obj.isAlive());
		obj.sleep(3000);
		System.out.println("Main thread ends");
	}
}
