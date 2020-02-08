package interfacesDemo;

public class Trainee implements DataProvider{
	private int marksSecured;
	
	public Trainee(int marksSecured) {
		this.marksSecured=marksSecured;
	}
	public void calcPercentage() {
		if(this.marksSecured>DataProvider.totalMaximumMarks) {
			System.out.println("Please enter the correct marks");
			return;
		}
		System.out.println("the total aggregate percentage secured is "+(this.marksSecured*100/(double)DataProvider.totalMaximumMarks));
	}
}
