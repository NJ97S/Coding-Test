import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		final int T = sc.nextInt();
		
		for (int testCase = 1; testCase <= T; testCase++) {
			final int N = sc.nextInt();
			final int M = sc.nextInt();
			
			final int[] arrA = new int[N];
			for (int i = 0; i < N; i++) {
				arrA[i] = sc.nextInt();
			}
			
			final int[] arrB = new int[M];
			for (int i = 0; i < M; i++) {
				arrB[i] = sc.nextInt();
			}
			
			int[] bigger;
			int[] smaller;
			
			if (N > M) {
				bigger = arrA;
				smaller = arrB;
			} else {
				bigger = arrB;
				smaller = arrA;
			}
			
			int answer = Integer.MIN_VALUE;
			
			for (int i = 0; i <= bigger.length - smaller.length; i++) {
				int result = 0;
				
				for (int j = 0; j < smaller.length; j++) {
					result += bigger[i + j] * smaller[j];
				}
				
				answer = Math.max(answer, result);
			}
			
			System.out.printf("#%d %d\n",testCase, answer);
		}
		
		sc.close();
		
	}
	
}