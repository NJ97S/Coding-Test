import java.util.Scanner;

public class Solution {
	
	static Scanner sc;
	
	static int N; // 밑
	static int M; // 지수
	
	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
		
		for (int testCase = 1; testCase <= 10; testCase++) {			
			sc.nextInt();
			
			N = sc.nextInt();
			M = sc.nextInt();
			
			System.out.printf("#%d %d\n", testCase, pow(N, M));
		}
		
	}
	
	static int pow(int N, int M) {
		if (M <= 1) return N;
		
		int temp = pow(N, M / 2);
		
		if (M % 2 == 0) return temp * temp;
		else return temp * temp * N;
	}
	
}