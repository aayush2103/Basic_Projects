package PolymorphismDemo;

public class PRTester {

	public static void main(String[] args) {
		PlayerRating p1=new PlayerRating(1, "Beckham");
		p1.calculateAverageRating(9, 9.9f);
		p1.display();
		
		PlayerRating p2=new PlayerRating(1, "Oscar");
		p2.calculateAverageRating(1f, 1, 1);
		p2.display();
	}

}
