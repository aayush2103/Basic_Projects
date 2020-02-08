package OverridingAndSuper;

public class TeamEventRegistration extends EventRegistration{
	private int noOfParticipants;
	private int teamNo;
	public TeamEventRegistration(String name, String nameOfEvent, int noOfParticipants, int teamNo) {
		super(name, nameOfEvent);
		this.noOfParticipants=noOfParticipants;
		this.teamNo=teamNo;
	}
	public void registerEvent() {
		String str=this.nameOfEvent;
		this.registrationFee=(str.equals("ShakeALeg"))?50:(str.equals("Sing&Win"))?60:(str.equals("Actathon"))?80:100;
		this.registrationFee*=this.noOfParticipants;
	}
	public int getNoOfParticipants() {
		return noOfParticipants;
	}
	public void setNoOfParticipants(int noOfParticipants) {
		this.noOfParticipants = noOfParticipants;
	}
	public int getTeamNo() {
		return teamNo;
	}
	public void setTeamNo(int teamNo) {
		this.teamNo = teamNo;
	}
	
}
