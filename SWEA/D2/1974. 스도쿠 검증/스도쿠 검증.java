import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        final int T = sc.nextInt();
        
        caseLoop: for (int testCase = 1; testCase <= T; testCase++) {
        	int[][] INPUT = new int[9][9];
        	for (int i = 0; i < 9; i++) {
        		for (int j = 0; j < 9; j++) {
        			INPUT[i][j] = sc.nextInt();
        		}
        	}
        	
        	// 가로줄, 세로줄 탐색
        	for (int r = 0; r < 9; r++) {
        		Set<Integer> rowSet = new HashSet<>();
        		Set<Integer> colSet = new HashSet<>();
        		
        		for (int c = 0; c < 9; c++) {
        			rowSet.add(INPUT[r][c]);
        			colSet.add(INPUT[c][r]);
        		}
        		
        		if (rowSet.size() < 9 || colSet.size() < 9) {
        			System.out.printf("#%d %d\n", testCase, 0);
        			
        			continue caseLoop;
        		}
        	}
        	
        	// 3*3 탐색
        	for (int r = 0; r <= 6; r += 3) {
        		for (int c = 0; c <= 6; c += 3) {
        			Set<Integer> boxSet = new HashSet<>();
        			
        			for (int n = 0; n < 3; n++) {
        				for (int m = 0; m < 3; m++) {
        					boxSet.add(INPUT[r + n][c + m]);
        				}
        			}
        			
        			if (boxSet.size() < 9) {
        				System.out.printf("#%d %d\n", testCase, 0);
            			
        				continue caseLoop;
        			}
        		}
        	}
        	
        	System.out.printf("#%d %d\n", testCase, 1);
        }
        
        sc.close();
    }
    
}
