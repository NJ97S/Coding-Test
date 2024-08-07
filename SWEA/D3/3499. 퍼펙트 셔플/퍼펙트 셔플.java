import java.util.Scanner;

public class Solution {
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        final int T = sc.nextInt();
        
        for (int testCase = 1; testCase <= T; testCase++) {
        	final int N = sc.nextInt();
        	
        	String[] INPUT = new String[N];
        	for (int i = 0; i < N; i++) {
        		INPUT[i] = sc.next();
        	}
      
        	int midIdx;
        	
        	if (INPUT.length % 2 == 0) midIdx = INPUT.length / 2;
        	else midIdx = INPUT.length / 2 + 1;
        	
        	String answer = "";
        	for (int i = 0; i < INPUT.length / 2; i++) {
        		answer += INPUT[i] + " " + INPUT[midIdx + i] + " ";
        	}
        	
        	if (INPUT.length % 2 != 0) answer += INPUT[midIdx - 1];
        	
        	System.out.printf("#%d %s\n", testCase, answer.trim());
        }
        
        sc.close();
    }
    
}
