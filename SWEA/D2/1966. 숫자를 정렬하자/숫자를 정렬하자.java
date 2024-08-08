import java.util.Scanner;

public class Solution {
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        final int T = sc.nextInt();
        
        for (int testCase = 1; testCase <= T; testCase++) {
        	final int N = sc.nextInt();
        	
        	int[] INPUT = new int[N];
        	for (int i = 0; i < N; i++) {
        		INPUT[i] = sc.nextInt();
        	}
        	
        	for (int i = 1; i < INPUT.length; i++) {
        		int curData = INPUT[i];
        		
        		int j;
        		for (j = i - 1; j >= 0 && INPUT[j] > curData; j--) {
        			INPUT[j + 1] = INPUT[j];
        		}
        		
        		INPUT[j + 1] = curData;
        	}
        	
        	System.out.printf("#%d", testCase);
        	
        	for (int elem: INPUT) System.out.printf(" %d", elem);
        	
        	System.out.println("");
        }
        
        sc.close();
    }
    
}
