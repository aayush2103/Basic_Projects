package InheritanceDemo;

public class EmployeeRecords {

	public static void main(String[] args) {
		
		PermanentEmployee pe=new PermanentEmployee();
		ContractEmployee ce=new ContractEmployee();
		
		pe.setBasicPay(10000);
		pe.setEmpId(101);
		pe.setExperience(3);
		pe.setHra(1500);
		pe.setName("Anil");
		
		ce.setEmpId(102);
		ce.setHours(10);
		ce.setName("Ankit");
		ce.setWages(500);
		
		pe.calculateSalary();
		ce.calculateSalary();
	}

}
