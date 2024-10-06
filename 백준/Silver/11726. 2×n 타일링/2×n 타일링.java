import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
[문제 링크]
- https://www.acmicpc.net/problem/11726
*/

/*
[문제 정리]
- 1 초 / 256 MB

- (2 * n) 크기의 직사각형을 (1 * 2) 또는 (2 * 1) 타일로 채우는 경우의 수 구하기
*/

/*
[풀이 방식]
- 1 또는 2로 n을 만드는 경우의 수를 구하면 됨. -> DP

  1  =>  (1)
  2  =>  (1, 1)       (2)
  3  =>  (1, 1, 1)    (2, 1)    (1, 2)
  4  =>  (1, 1, 1, 1) (2, 1, 1) (1, 2, 1) (1, 1, 2) (2, 2)

- n을 만드는 경우의 수 = (n - 2)를 만드는 경우의 수 + (n - 1)을 만드는 경우의 수
*/

public class Main {
	
	static BufferedReader br;
	
	static int N; // 직사각형 가로의 길이 (1 <= N <= 1,000)
	
	static int[] dp; // 1과 2를 사용하여, 특정한 숫자를 만드는 경우의 수
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		dp = new int[N + 1];
		
		dp[0] = dp[1] = 1;
		
		for (int n = 2; n <= N; n++) {
			dp[n] = (dp[n - 2] + dp[n - 1]) % 10007;
		}
		
		System.out.println(dp[N]);
		
	}
	
}