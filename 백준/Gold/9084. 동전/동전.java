import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
[문제 링크]
- https://www.acmicpc.net/problem/9084
*/

/*
[문제 정리]
- 1 초 / 128 MB

- 동전의 종류가 주어질 때 -> 주어진 금액을 만드는 모든 경우의 수
- 동전의 종류는 오름차순으로 정렬되어 주어짐.
*/

/*
[풀이 방식]
- 금액이 가장 작은 동전으로 만드는 경우의 수부터 금액을 높여가며 경우의 수 계산 -> DP
*/

public class Main {
	
	static BufferedReader br;
	static StringBuilder sb;
	
	static int N; // 동전 가지 수 (1 <= N <= 20)
	static int M; // 만들어야 하는 금액 (1 <= M <= 10,000)
	
	static int[] COINS;
	
	static int[] dp; // 특정 금액을 만들기 위한 경우의 수
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		final int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine());
			
			COINS = new int[N];
			
			String[] input = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				COINS[i] = Integer.parseInt(input[i]);
			}
			
			M = Integer.parseInt(br.readLine());
			
			// ---------------------- input ----------------------
			
			dp = new int[M + 1];
			dp[0] = 1;
			
			for (int i = 0; i < N; i++) { // COINS 배열의 인덱스
				for (int value = 1; value <= M; value++) {
					
					if (value >= COINS[i]) dp[value] += dp[value - COINS[i]];
					
				}
			}
			
			sb.append(dp[M]).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
}