import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
[문제 링크]
- https://www.acmicpc.net/problem/2579
*/

/*
[문제 정리]
- 1 초 / 128 MB

- 계단 오르는 규칙
  1. 한 번에 1 또는 2 계단 오를 수 있음.
  2. 연속된 3개의 계단을 모두 밟을 수는 없음.
  3. 마지막 도착 계단은 반드시 밟을 것

- 각 계단의 점수가 주어질 때, 얻을 수 있는 점수의 최댓값 구하기
*/

/*
[풀이 방식]
- (n - 2)번째 계단 -> n번째 계단  |  (n - 3)번째 계단 -> (n - 1)번째 계단 -> n번째 계단

- 1, 2, 3번째 계단까지는 값 미리 넣어주기
  - 3번째 계단의 경우, 3개 계단의 합을 모두 더한 값이 최대
*/

public class Main {
	
	static BufferedReader br;
	
	static int N; // 계단의 개수 (1 <= N <= 300)
	
	static int[] SCORES; // 각 계단의 점수 (1 <= score <= 10,000)
	
	static int[] dp; // 해당 계단에 도달했을 때 얻을 수 있는 점수의 최댓값
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		SCORES = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			SCORES[i] = Integer.parseInt(br.readLine());
		}
		
		// ------------------------- input -------------------------
		
		dp = new int[N + 1];
		
		// N이 3 미만일 때
		if (N < 3) {
			
			int sum = 0;
			
			for (int i = 1; i <= N; i++) {
				sum += SCORES[i];
			}
			
			System.out.println(sum);
			
			return;
			
		}
		
		// N이 3 이상일 때
		dp[1] = SCORES[1];
		dp[2] = dp[1] + SCORES[2];
		
		for (int stair = 3; stair <= N; stair++) {
			dp[stair] = Math.max(dp[stair - 3] + SCORES[stair - 1], dp[stair - 2]) + SCORES[stair];
		}

		System.out.println(dp[N]);
		
	}
	
}