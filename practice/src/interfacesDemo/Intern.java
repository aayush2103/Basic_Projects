package interfacesDemo;

public class Intern implements DataProvider{
	private int marksSecured;
	private int graceMarks;
	
	public Intern(int marksSecured, int graceMarks) {
		this.marksSecured=marksSecured;
		this.graceMarks=graceMarks;
	}
	public void calcPercentage() {
		int total=this.marksSecured+this.graceMarks;
		if(total>DataProvider.totalMaximumMarks) {
			System.out.println("Please enter the correct marks");
			return;
		}
		System.out.println("the total aggregate percentage secured is "+(total*100/(double)DataProvider.totalMaximumMarks));
	}
}
