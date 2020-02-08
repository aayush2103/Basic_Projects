package InheritanceDemo;

public class PermanentEmployee extends Employee {
	private double basicPay;
	private double hra;
	private int experience;
	public double getBasicPay() {
		return basicPay;
	}
	public void setBasicPay(double basicPay) {
		this.basicPay = basicPay;
	}
	public double getHra() {
		return hra;
	}
	public void setHra(double hra) {
		this.hra = hra;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	
	public void calculateSalary() {
		int var=(this.experience<3)? 0 :(this.experience>=3 && this.experience<5)? 5:
			(this.experience>=5 && this.experience<10)? 7:12;
		double salary=this.basicPay*(1+(var/100.0))+this.hra;
		System.out.println("Permanent Emploee: Your salary is:"+salary);
	}
}
