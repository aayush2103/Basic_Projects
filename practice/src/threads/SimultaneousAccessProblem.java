package threads;

class Course{
	String courseName;
	int noOfSeats;
	
	public Course(String name, int seats){
		this.courseName=name;
		this.noOfSeats=seats;
	}
	
	/*synchronized block*/
	//public synchronized void registerForCourse(int rollNo) {
	
	/*non synchronized block*/
	public void registerForCourse(int rollNo) {
		try {
			if(this.noOfSeats-1 < 0) {
				throw new Exception("No more seats available.");
			}
			System.out.println("Booking Successfull");
			this.noOfSeats -=1;
			System.out.println("Available seats : "+this.noOfSeats);
		}
		catch(Exception e) {
			System.out.println("Error : "+e.getMessage());
		}
	}
}

class Register extends Thread{
	Course c;
	public Register(Course course) {
		this.c=course;
	}
	@Override
	public void run() {
		c.registerForCourse(1);
	}
}

public class SimultaneousAccessProblem {
	public static void main(String[] args) {
		Course cse = new Course("cse", 1);
		Register r1= new Register(cse);
		//r1.setPriority(Thread.MIN_PRIORITY);
		r1.start();
		Register r2 = new Register(cse);
		//r2.setPriority(Thread.MAX_PRIORITY);
		r2.start();
	}
}
