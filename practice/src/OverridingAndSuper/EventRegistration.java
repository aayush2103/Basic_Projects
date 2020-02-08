package OverridingAndSuper;

public class EventRegistration {
	String name;
	String nameOfEvent;
	double registrationFee;
	EventRegistration(String name, String nameOfEvent){
		this.name=name;
		this.nameOfEvent=nameOfEvent;
	}
	public void registerEvent() {
		String str=this.nameOfEvent;
		this.registrationFee=(str.equals("ShakeALeg"))?100:(str.equals("Sing&Win"))?150:(str.equals("Actathon"))?70:130;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNameOfEvent() {
		return nameOfEvent;
	}
	public void setNameOfEvent(String nameOfEvent) {
		this.nameOfEvent = nameOfEvent;
	}
	public double getRegistrationFee() {
		return registrationFee;
	}
	public void setRegistrationFee(double registrationFee) {
		this.registrationFee = registrationFee;
	}
}
