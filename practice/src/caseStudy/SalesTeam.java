package caseStudy;

public class SalesTeam extends Team {
	private int salesNumber;
	
	public SalesTeam(String address, String name, int phone, int empId, String dept, int salesNumber) {
		super(address, name, phone, empId, dept);
		this.salesNumber=salesNumber;
	}
	public int getSalesNumber() {
		return salesNumber;
	}

	public void setSalesNumber(int salesNumber) {
		this.salesNumber = salesNumber;
	}
	
}
