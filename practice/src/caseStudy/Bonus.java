package caseStudy;

public interface Bonus {
	long SILVER=150000;
	long GOLD=100000;
	long DIAMOND=50000;
	
	long calculateBonusPayout(int actualSales, int targetSales);
}
