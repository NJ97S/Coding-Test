import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
[문제 링크]
- 
*/

/*
[문제 정리]
- 물건 n개 선택해서 가치의 합이 최대가 되게 만들기
- 단, 선택한 물건의 합 <= K 조건을 만족해야 한다.
*/

public class Solution {
	
	static BufferedReader br;
	static StringBuilder sb;
	
	static int N; // 물건의 개수 (1 <= N <= 100)
	static int K; // 최대 부피 (1 <= K <= 1,000)
	
	static int[] SIZES; // 각 물건의 부피 (1 <= 부피 <= 100)
	static int[] VALUES; // 각 물건의 가치 (1 <= 가치 <= 100)
	
	static int[][] dp; // 물건 인덱스, 제한 부피 -> 물건을 n개까지 봤을 때, 특정 부피에서의 최대 가치
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		final int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");
			
			String[] input = br.readLine().split(" ");
			N = Integer.parseInt(input[0]);
			K = Integer.parseInt(input[1]);
			
			SIZES = new int[N + 1];
			VALUES = new int[N + 1];
			
			for (int i = 1; i <= N; i++) {
				input = br.readLine().split(" ");
				
				SIZES[i] = Integer.parseInt(input[0]);
				VALUES[i] = Integer.parseInt(input[1]);
			}
			
			// ------------------------ input ------------------------
			
			dp = new int[N + 1][K + 1];
			
			for (int i = 1; i <= N; i++) { // 물건 인덱스
				for (int j = 1; j <= K; j++) { // 제한 부피
					
					if (SIZES[i] <= j) dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - SIZES[i]] + VALUES[i]);
					else dp[i][j] = dp[i - 1][j];
					
				}
			}
			
			sb.append(dp[N][K]).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
}