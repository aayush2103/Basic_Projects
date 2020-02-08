package PolymorphismDemo;

public class PlayerRating {
	private int playerPosition;
	private String playerName;
	private float criticOneRating;
	private float criticTwoRating;
	private float criticThreeRating;
	private float averageRating;
	private char category;
	
	PlayerRating(int playerPosition, String playerName) {
		this.playerPosition=playerPosition;
		this.playerName=playerName;
	}
	public void calculateAverageRating(float criticOneRating, float criticTwoRating) {
		this.averageRating=(criticOneRating+criticTwoRating)/2;
		this.calculateCategory();
	}
	public void calculateAverageRating(float criticOneRating, float criticTwoRating,
			float criticThreeRating) {
		this.averageRating=(criticOneRating+criticTwoRating+criticThreeRating)/3;
		this.calculateCategory();
	}
	public void calculateCategory() {
		float avg=this.averageRating;
		this.category=(avg>8)?'A':(avg>5 && avg<=8)?'B':'C';
	}
	public void display() {
		System.out.println("the player name is "+this.playerName);
		System.out.println("the player position is "+this.playerPosition);
		System.out.println("the average rating is "+this.averageRating);
		System.out.println("the category is "+this.category);
	}
}
