package OverridingAndSuper;

public class RegistrationTester {

	public static boolean isValid(String str) {
		boolean flag=(str.equals("ShakeALeg"))?true:(str.equals("Sing&Win"))?true:(str.equals("Actathon"))?true:
			(str.equals("PlayAway"))?true:false;
		return flag;
	}
	public static void display(String name, String event, double fee, int no) {
		System.out.println("Thank You "+name+" for your participation.Your registration fee is: "+fee+"\nYou are"
				+ " participantno: "+no);
		System.out.println();
	}
	public static void main(String[] args) {
		SingleEventRegistration p1=new SingleEventRegistration("Jenny", "Sing&Win", 1);
		if(isValid(p1.nameOfEvent) && (!p1.getNameOfEvent().equals("Acathon"))) {
			p1.registerEvent();
			display(p1.getName(),p1.getNameOfEvent(),p1.getRegistrationFee(),p1.getParticipantNo());
		}
		else
			System.out.println("Please choose a valid event");
		
		TeamEventRegistration t1=new TeamEventRegistration("Aura", "ShakeALeg", 5, 1);
		if(isValid(t1.nameOfEvent)) {
			t1.registerEvent();
			display(t1.getName(),t1.getNameOfEvent(),t1.getRegistrationFee(),t1.getTeamNo());
		}
		else
			System.out.println("Please choose a valid event");
		
		SingleEventRegistration p2=new SingleEventRegistration("Hudson", "PlayAway", 2);
		if(isValid(p2.nameOfEvent) && (!p2.getNameOfEvent().equals("Acathon"))) {
			p2.registerEvent();
			display(p2.getName(),p2.getNameOfEvent(),p2.getRegistrationFee(),p2.getParticipantNo());
		}
		else
			System.out.println("Please choose a valid event");
	}

}
