import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        for (int testCase = 1; testCase <= 10; testCase++) {
        	sc.nextInt();
        	
        	Queue<Integer> queue = new LinkedList<>();
        	
        	for (int i = 1; i <= 8; i++) queue.add(sc.nextInt());
        	
        	int head = queue.peek();
        	int removeNum = 1;
        	
        	while (head > 0) {		
        		queue.poll();
        		
        		if (head - removeNum <= 0) {
        			queue.add(0);
        			
        			break;
        		}
        		
        		queue.add(head - removeNum++);
        		
        		if (removeNum > 5) {
        			if (removeNum % 5 == 0) removeNum = 5;
        			else removeNum = removeNum % 5;
        		}
        		
        		head = queue.peek();
        	}
        	
        	System.out.print("#" + testCase);
        	
        	String answer = "";
        	while (!queue.isEmpty()) answer += " " + queue.poll();
        	
        	System.out.println(answer);
        }
        
        sc.close();
    }
    
}
