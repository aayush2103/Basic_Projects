package threads;

class Course1{
	String courseName;
	int noOfSeats;
	
	public Course1(String name, int seats) {
		this.courseName = name;
		this.noOfSeats = seats;
	}
	
	public synchronized void registerForCourse(int rollNo) {
		try {
			if(this.noOfSeats -1 < 0) {
				this.wait(5000);
				if(this.noOfSeats -1 < 0) {
					throw new Exception("No seats available");
				}
			}
			System.out.println("Booking successfull");
			this.noOfSeats -= 1;
			System.out.println("Seats Available : "+this.noOfSeats);
		}
		catch(Exception e) {
			System.out.println("Error : "+e.getMessage());
		}
	}
	
	public synchronized void cancelSeats() {
		try {
			this.noOfSeats += 1;
			System.out.println("Cancellation Successfull");
			System.out.println("Seats Available : "+this.noOfSeats);
			this.notify();
		}
		catch(Exception e) {
			System.out.println("Eror : "+e.getMessage());
		}
	}
}

class Register1 extends Thread{
	Course1 c;
	public Register1(Course1 course) {
		this.c = course;
	}
	@Override
	public void run() {
		c.registerForCourse(1);
	}
}

class CancelRegistration1 extends Thread{
	Course1 course;
	
	public CancelRegistration1(Course1 c) {
		this.course = c;
	}
	@Override
	public void run() {
		course.cancelSeats();
	}
}

public class InterThreadComunication {
	public static void main(String[] args) throws InterruptedException {
		Course1 course = new Course1("cse", 1);
		Register1 r1 = new Register1(course);
		r1.start();
		Register1 r2 = new Register1(course);
		r2.start();
		Thread.sleep(2000);
		CancelRegistration1 cr = new CancelRegistration1(course);
		cr.start();
	}
}
