package handsOn;

public class RoomDetails implements RoomBillComponent{
	private int billId;
	private String customerName;
	private String typeOfRoom;
	private int noOfExtraPersons;
	private int noOfDaysOfStay;
	private static int counter=100;
	
	public RoomDetails(String custName, String roomType, int extraPersons, int days) {
		this.customerName=custName;
		this.typeOfRoom=roomType;
		this.noOfExtraPersons=extraPersons;
		this.noOfDaysOfStay=days;
		this.billId=counter++;
	}
	public boolean validateNoOfDaysOfStay() throws Exception{
		int days=this.noOfDaysOfStay;
		if(days<1)
			throw new Exception("Error: Please book for a minimum of 1 day");
		else if(days>15)
			throw new Exception("Error: Please book for a maximum of 15 day");
		return true;
	}
	public boolean validateNoOfExtraPersons() throws Exception{
		if(this.noOfExtraPersons>=0 && this.noOfExtraPersons<=2)
			return true;
		else
			throw new Exception("Error: Max of 2 extra persons allowed per Room");
	}
	public boolean validateTypeOfRoom() throws Exception{
		String str=this.typeOfRoom.toLowerCase();
		if(str.equals("standard") || str.equals("deluxe") || str.equals("cottage"))
			return true;
		throw new Exception("Invalid Room Type");
	}
	public float calculateBill() throws Exception{
		this.validateNoOfDaysOfStay();
		this.validateNoOfExtraPersons();
		this.validateTypeOfRoom();
		String str=this.typeOfRoom.toLowerCase();
		double basePrice=(str.equals("standard"))? 2500:(str.equals("deluxe"))? 3500:5500;
		double totalBill=(this.noOfDaysOfStay*(basePrice+RoomBillComponent.FOOD_CHARGE))+
				(this.noOfExtraPersons*RoomBillComponent.EXTRA_PAERSON_CHARGE);
		totalBill+=totalBill*RoomBillComponent.TAX;
		return (float)totalBill;
	}
	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getTypeOfRoom() {
		return typeOfRoom;
	}
	public void setTypeOfRoom(String typeOfRoom) {
		this.typeOfRoom = typeOfRoom;
	}
	public int getNoOfExtraPersons() {
		return noOfExtraPersons;
	}
	public void setNoOfExtraPersons(int noOfExtraPersons) {
		this.noOfExtraPersons = noOfExtraPersons;
	}
	public int getNoOfDaysOfStay() {
		return noOfDaysOfStay;
	}
	public void setNoOfDaysOfStay(int noOfDaysOfStay) {
		this.noOfDaysOfStay = noOfDaysOfStay;
	}
	
}
