package handsOn;

public interface RoomBillComponent {
	double TAX=0.12;
	double EXTRA_PAERSON_CHARGE=500;
	double FOOD_CHARGE=800;
	
	float calculateBill()throws Exception;
}
