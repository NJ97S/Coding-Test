import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
[문제 링크]
- https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PpFQaAQMDFAUq
*/

/*
[문제 정리]
- 3 초 / 256 MB

- 이용권 종류
  1. 1일 이용권
  2. 1달 이용권 (매달 1일부터 시작)
  3. 3달 이용권 (매달 1일부터 시작 / 다음 해로 기간이 넘어가지는 않음)
  4. 1년 이용권 (매년 1월 1일부터 시작)

- 각 이용권의 요금과, 각 달의 이용 계획이 주어지면,
- 수영장을 이용할 수 있는 최저 금액 구하기
*/

/*
[풀이 방식]
- 1일 이용권 선택 -> 지난 달까지의 요금 + (이용횟수 * 1일 이용권)
- 1달 이용권 선택 -> 지난 달까지의 요금 + 1달 이용권
- 3달 이용권 선택 -> 3달 전까지의 요금 + 3달 이용권

- 1년 이용권 선택 -> 위의 최적해와 비교
*/

public class Solution {
	
	static BufferedReader br;
	static StringBuilder sb;
	
	static int[] PRICES;
	static int[] PLAN;
	
	static int[] dp; // 최소 금액
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		final int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");
			
			String[] input = br.readLine().split(" ");
			
			PRICES = new int[4];
			for (int i = 0; i < 4; i++) {
				PRICES[i] = Integer.parseInt(input[i]);
			}
			
			input = br.readLine().split(" ");
			
			PLAN = new int[12];
			for (int i = 0; i < 12; i++) {
				PLAN[i] = Integer.parseInt(input[i]);
			}
			
			// ----------------------- input -----------------------
			
			dp = new int[13];
			
			for (int i = 1; i <= 12; i++) {
				
				dp[i] = dp[i - 1] + PRICES[0] * PLAN[i - 1]; // 1일 이용권
				
				dp[i] = Math.min(dp[i], dp[i - 1] + PRICES[1]); // 1달 이용권
				
				if (i >= 3) { // 3달 이용권
					dp[i] = Math.min(dp[i], dp[i - 3] + PRICES[2]);
				}
				
				if (i == 12) { // 1년 이용권
					dp[i] = Math.min(dp[i], PRICES[3]);
				}
				
			}
			
			sb.append(dp[12]).append("\n");
			
		}
		
		System.out.println(sb);
		
	}
	
}