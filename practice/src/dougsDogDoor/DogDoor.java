package dougsDogDoor;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class DogDoor {
	private boolean open;
	private List<Bark> allowedBarks = new ArrayList<Bark>();
	
	public DogDoor() {
		this.open = false;
	}
	
	public void open() {
		System.out.println("The Dog Door opens.");
		this.open = true;
		
		final Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run() {
				close();
				timer.cancel();
			}
		}, 5000);
	}
	
	public void close() {
		System.out.println("the Dog Door closes.");
		this.open = false;
	}
	
	public boolean isOpen() {
		return this.open;
	}
	
	public void addAllowedBark(Bark bark) {
		allowedBarks.add(bark);
	}
	
	public List<Bark> getAllowedBarks() {
		return this.allowedBarks;
	}
}
