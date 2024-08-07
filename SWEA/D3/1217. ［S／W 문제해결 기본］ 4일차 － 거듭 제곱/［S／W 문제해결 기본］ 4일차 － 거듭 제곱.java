import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		for (int testCase = 1; testCase <= 10; testCase++) {
			sc.nextInt();
			
			final int N = sc.nextInt();
			final int M = sc.nextInt();
			
			int answer = multiply(N, M);
			
			System.out.printf("#%d %d\n", testCase, answer);
		}
		
		sc.close();
		
	}
	
	static int multiply(int N, int M) {		
		if (M == 0) return 1;
		
		return N * multiply(N, M - 1);
	}

}