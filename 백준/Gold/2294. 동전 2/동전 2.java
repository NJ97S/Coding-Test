import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
[문제 링크]
- https://www.acmicpc.net/problem/2293
*/


/*
[문제 정리]
- 1 초 / 128 MB

- n가지 종류의 동전 -> 중복 선택 가능
- 가치의 합이 K원이 되도록 하는 경우의 수 구하기

- 순서는 고려하지 않음.
*/

public class Main {
	
	static BufferedReader br;
	
	static int N; // 동전의 종류 (1 <= N <= 100)
	static int K; // 만들어야 하는 합 (1 <= K <= 10,000)
	
	static int[] VALUES; // 동전의 가치 (1 <= 가치 <= 100,000)
	static int MAX_VALUE;
	
	static int[] dp; // 특정 가치를 만드는 동전의 수
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]);
		K = Integer.parseInt(input[1]);
		
		VALUES = new int[N];
		
		for (int i = 0; i < N; i++) {
			int value = Integer.parseInt(br.readLine());
			
			VALUES[i] = value;
			
			MAX_VALUE = Math.max(MAX_VALUE, value);
		}
		
		// ----------------------- input -----------------------
		
		dp = new int[K + 1];
		
		Arrays.fill(dp, 100001);
		dp[0] = 0;
		
		for (int limit = 1; limit <= K; limit++) {
			
			for (int value: VALUES) {
				
				if (limit >= value) dp[limit] = Math.min(dp[limit], dp[limit - value] + 1);
				
			}
			
		}
		
		System.out.println(dp[K] == 100001 ? -1 : dp[K]);
		
	}
	
}