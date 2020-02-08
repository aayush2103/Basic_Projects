package caseStudy;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Team team1=new MarketingTeam("","Jack",1234,001,"",21);
		Team team2=new MarketingTeam("","John",1235,002,"",22);
		Team team3=new SalesTeam("","Tom",1236,003,"",23);
		Team team4=new SalesTeam("","Jili",1237,004,"",24);
		
		display(team1, 900, 1500);
		display(team2, 1550, 1500);
		display(team3, 1500, 1500);
		display(team4, 1400, 1500);
	}
	public static void display(Team team, int actualSales, int targetSales) {
		long b=team.calculateBonusPayout(actualSales, targetSales);
		if (b==0) {
			System.out.println(team.getName()+" good work, try to achieve more !!");
		}
		else
			System.out.println("Bonus for "+team.getName()+" is: Rs."+b);
	}

}
