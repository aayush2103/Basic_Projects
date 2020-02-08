package OOAD;

public class TestPlane {
	public static void main(String[] args) {
		
		//FlyTest1();
		FlyTest2();
	}
	
	public static void FlyTest1() {
		Airplane airplane = new Airplane();
		airplane.speed = 212;
		System.out.println(airplane.speed);
	}
	
	public static void FlyTest2() {
		Jet jet1 = new Jet();
		jet1.speed = 212;
		System.out.println(jet1.speed);
		
		Jet jet2 = new Jet();
		jet2.setSpeed(212);
		System.out.println(jet2.getSpeed());
	}
}
