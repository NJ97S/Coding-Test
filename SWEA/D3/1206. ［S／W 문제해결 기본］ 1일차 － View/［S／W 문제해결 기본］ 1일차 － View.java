import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for (int i = 1; i <= 10; i++) {
			final int N = sc.nextInt();
			
			int[] input = new int[N];
			for (int j = 0; j < N; j++) {
				input[j] = sc.nextInt();
			}
			
			int caseAnswer = 0;
			
			for (int k = 2; k < N - 2; k++) {
				int[] neighbor = {input[k-2], input[k-1], input[k+1], input[k+2]};
				Arrays.sort(neighbor);
				
				if (input[k] > neighbor[3]) caseAnswer += input[k] - neighbor[3];
			}
			
			System.out.format("#%d %d\n", i, caseAnswer);
		}

	}

}
