package handsOn;

public class Tester {
	
	public static void display(RoomDetails room, float bill) {
		System.out.println("Booking Successful !!");
		System.out.println("Bill Id: "+room.getBillId());
		System.out.println("Customer Name: "+room.getCustomerName());
		System.out.println("No, Of Days stay: "+room.getNoOfDaysOfStay());
		System.out.println("Total Bill: "+bill);
		System.out.println();
	}
	public static void main(String[] args) {
		try {
			RoomDetails r1=new RoomDetails("Aayush", "Cottage", 2, 12);
			float p1=r1.calculateBill();
			display(r1, p1);
			
			RoomDetails r2=new RoomDetails("Shantam", "Deluxe", 2, 15);
			float p2=r2.calculateBill();
			display(r2, p2);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
