package caseStudy;

public class Team implements Bonus{
	private String addrerss;
	private String name;
	private int phoneNo;
	private int empId;
	private String dept;
	private String rating;
	
	public Team(String address, String name, int phone, int empId, String dept) {
		this.addrerss=address;
		this.name=name;
		this.phoneNo=phone;
		this.empId=empId;
		this.dept=dept;
	}
	public long calculateBonusPayout(int actualSales, int targetSales) {
		float avg=((float)actualSales*100)/targetSales;
		long bon=(avg>100)?Bonus.DIAMOND:(avg==100)?Bonus.GOLD:(avg>90 && avg<100)?Bonus.SILVER:0;
		return bon;
	}

	public String getAddrerss() {
		return addrerss;
	}

	public void setAddrerss(String addrerss) {
		this.addrerss = addrerss;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}
	
}
