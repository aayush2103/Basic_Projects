package demo;

public class ArrayDemo {

	public static void main(String[] args) {
		double salary[]= {23500,25080,28760,22340,19890};
		double avg=0;
		for(double i: salary) {
			avg+=i;
		}
		avg/=salary.length;
		System.out.println("The average salary of the employee is: "+avg);
		
		int g=0,l=0;
		for(double i: salary) {
			if(i<avg)
				l++;
			else
				g++;
		}
		System.out.println("The number of employees having salary greater than the "
				+ "average is: "+g);
		System.out.println("The number of employees having salary lesser than the "
				+ "average is: "+l);
	}
}
