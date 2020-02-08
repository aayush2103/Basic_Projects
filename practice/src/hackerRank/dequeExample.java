package hackerRank;

import java.util.*;

public class dequeExample {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();
        int max=0;
        HashSet hs=new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.add(num);
            hs.add(num);
            
            if(deque.size()==m+1) {
            	int out=(int)deque.remove();
            	if(!deque.contains(out))
            		hs.remove(out);
            }
            max=Math.max(hs.size(), max);
            if(max==m)
            	break;
        }
        System.out.println(max);
    }
}