package interfacesDemo;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataProvider i=new Intern(5000, 500);
		i.calcPercentage();
		
		i=new Intern(8000,500);
		i.calcPercentage();
		
		i=new Trainee(6000);
		i.calcPercentage();
	}

}
