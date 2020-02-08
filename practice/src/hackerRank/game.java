package hackerRank;

import java.util.*;

public class game {
    public static boolean canWin(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.
    	
    	return isSolvable(leap, game, 0);
    	
//    	int i=0;
//    	boolean flag=true;
//    	while(i+leap<game.length) {
//    		System.out.println("run...");
//    		if(game[i+leap]==0)
//        		i+=leap;
//    		else if(game[i+1]==0 && flag) {
//        		i+=1;
//        		flag=!flag;
//    		}
//    		else if((i-1)>=0 && flag) {
//    			if(game[i-1]==0) {
//    				i-=1;
//        			flag=!flag;
//    			}
//    		}
//    		else 
//    			return false;
//    	}
//    	return true;
    }
    
    public static boolean isSolvable(int leap, int[] game, int i) {
    	if(i<0 || game[i]==1)
    		return false;
    	if((i+leap>=game.length) || (i+1)>=game.length)
    		return true;
    	
    	game[i]=1;
    	
    	return isSolvable(leap, game, i+1) || 
    		   isSolvable(leap, game, i-1) ||
    		   isSolvable(leap, game, i+leap);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();
            
            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}
