import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
[문제 링크]
- https://www.acmicpc.net/problem/9095
*/

/*
[문제 정리]
- 1 초 / 512 MB

- 정수 N을 1, 2, 3의 합으로 나타내는 방법의 수 구하기
*/

public class Main {
	
	static BufferedReader br;
	static StringBuilder sb;
	
	static int N; // 1 <= N < 11
	
	static int answer;
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		final int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine());
			
			answer = 0;
			
			makeNumber(0);
			
			sb.append(answer).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	static void makeNumber (int n) {
		
		// 기저 조건
		if (n == N) answer++;
		
		if (n >= N) return;
		
		// 재귀 부분
		makeNumber(n + 3);
		makeNumber(n + 2);
		makeNumber(n + 1);
		
	}
	
}