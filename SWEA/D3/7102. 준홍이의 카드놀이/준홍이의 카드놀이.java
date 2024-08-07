import java.util.Scanner;

/*
2	3	4	5	6
3	4	5	6	7
4	5	6	7	8
5	6	7	8	9
*/

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        final int T = sc.nextInt();
        
        for (int testCase = 1; testCase <= T; testCase++) {
        	final int N = sc.nextInt();
        	final int M = sc.nextInt();
        	
        	int bigger = Math.max(N, M);
        	int smaller = Math.min(N, M);
        	
        	int[] answer = new int[bigger - smaller + 1];
        	
        	for (int i = 0; i < answer.length; i++) {
        		answer[i] = smaller + 1 + i;
        	}
        	
        	System.out.printf("#%d ", testCase);
        	
        	String result = "";
        	for (int num: answer) result += num + " ";
        	
        	System.out.println(result.trim());
        }
        
        sc.close();

    }
}
