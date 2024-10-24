import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
[문제 링크]
- https://www.acmicpc.net/problem/1932
*/

/*
[문제 정리]
- 2 초 / 128 MB

- 삼각형의 최상단부터 시작하여, 한 층씩 아래로 내려올 때,
- 선택된 수의 합의 최댓값 구하기

- 현재 숫자의 대각선 왼쪽 또는 대각선 오른쪽 아래로만 내려갈 수 있다.
*/

/*
[풀이 방식]
- N번째 줄의 M번째 요소를 선택했을 때 최댓값 = M + (N - 1)번째 줄까지의 최댓값
*/

public class Main {
	
	static BufferedReader br;
	
	static int N; // 삼각형 크기 (1 <= N <= 500)
	
	static int[][] TRIANGLE;
	
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		TRIANGLE = new int[N][N + 1];
		
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			
			for (int j = 0; j <= i; j++) {
				TRIANGLE[i][j + 1] = Integer.parseInt(input[j]);
			}
		}
		
		// ---------------------- input ----------------------
		
		dp = new int[2][N + 2];
		dp[0][1] = TRIANGLE[0][1];
		
		for (int r = 1; r < N; r++) {
			for (int c = 1; c <= r + 1; c++) {
				
				if (r % 2 != 0) {
					dp[1][c] = TRIANGLE[r][c] + Math.max(dp[0][c - 1], dp[0][c]);
				}
				
				else {
					dp[0][c] = TRIANGLE[r][c] + Math.max(dp[1][c - 1], dp[1][c]);
				}
				
			}
		}
		
		int answer = N % 2 == 0 ? findMaxValue(true) : findMaxValue(false);
		
		System.out.println(answer);
		
	}
	
	static int findMaxValue(boolean isEven) {
	
		int result = 0;
		
		int idx = isEven ? 1 : 0;
		
		for (int value: dp[idx]) {
			result = Math.max(result, value);
		}
		
		return result;
		
	}
	
}