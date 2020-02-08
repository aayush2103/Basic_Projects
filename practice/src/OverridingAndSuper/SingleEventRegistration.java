package OverridingAndSuper;

public class SingleEventRegistration extends EventRegistration{
	private int participantNo;
	public SingleEventRegistration(String name, String nameOfEvent, int participantNo) {
		super(name, nameOfEvent);
		this.participantNo=participantNo;
	}
	public void registerEvent() {
		if(!this.nameOfEvent.equals("Actathon"))
			super.registerEvent();
	}
	public int getParticipantNo() {
		return participantNo;
	}
	public void setParticipantNo(int participantNo) {
		this.participantNo = participantNo;
	}
	
}
