package enumDemo;

enum Designation{
	CEO,GeneralManager(4),RegionalManager(20),BranchManager(30);
	
	private int noOfEmployees;
	
	Designation(){
		
	}
	
	Designation(int num){
		this.noOfEmployees=num;
	}
	public int getNoOfEmployees() {
		return this.noOfEmployees;
	}
}

public class enum1 {
	public void reportees(Designation designation) {
		System.out.println(designation.getNoOfEmployees());
	}
	public static void main(String[] args) {
		enum1 e=new enum1();
		e.reportees(Designation.CEO);
		for(Designation des:Designation.values())
			System.out.println(des.name()+des.getNoOfEmployees());
	}
}
