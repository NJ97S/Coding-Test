import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
[문제 링크]
- https://www.acmicpc.net/problem/11053
*/

/*
[문제 정리]
- 1 초 / 256 MB

- 가장 긴 증가하는 부분 수열(LIS)의 길이 구하기
- {10, 20, 10, 30, 20, 50} => {10, 20, 30, 50}
*/

/*
[풀이 방식]
- n번째 값을 마지막으로 하는 LIS 길이 = n번째 값보다 작은 수들의 LIS 길이 중 최댓값 + 1
*/

public class Main {
	
	static BufferedReader br;
	
	static int N; // 수열의 크기 (1 <= N <= 1,000)
	
	static int[] NUMBERS;
	
	static int[] dp; // 특정 값을 마지막 원소로 하는 LIS 길이
	
	static int maxOfLength; // 최대 길이
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		NUMBERS = new int[N];
		
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) { 
			NUMBERS[i] = Integer.parseInt(input[i]);
		}
		
		// ----------------------- input -----------------------
		
		dp = new int[N + 1];
		Arrays.fill(dp, 1);
		
		for (int i = 2; i <= N; i++) {
			int max = 0; // i번째 값보다 작은 수들의 dp[i] 중 최댓값
			
			for (int j = 1; j <= i; j++) {
				if (NUMBERS[j - 1] < NUMBERS[i - 1]) max = Math.max(max, dp[j]);
			}
			
			dp[i] = max > 0 ? max + 1 : 1;
		}
		
		maxOfLength = 0;
		
		for (int i = 1; i <= N; i++) {
			maxOfLength = Math.max(maxOfLength, dp[i]);
		}
		
		System.out.println(maxOfLength);
		
	}
	
}