import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
[문제 링크]
- https://www.acmicpc.net/problem/1463
*/

/*
[문제 정리]
- 0.15 초 / 128 MB

- 정수 X에 대해 사용 가능한 연산
  1. X % 3 == 0  =>  X / 3
  2. X % 2 == 0  =>  X / 2
  3. X - 1

- 세 개의 연산을 적절히 사용하여 1을 만들어야 한다.

- 최소 연산 수 구하기
*/

public class Main {
	
	static BufferedReader br;
	
	static int N; // 1 <= N <= 1,000,000
	
	static int minCount; // 최소 연산 수
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		minCount = N;
		
		makeOne(N, 0);
		
		System.out.println(minCount);
		
	}
	
	static void makeOne(int n, int count) {
		
		// 기저 조건
		if (n == 1) {
			minCount = Math.min(minCount, count);
			return;
		}
		
		if (n < 1 || count > minCount) return;
		
		// 재귀 부분
		if (n % 3 == 0) makeOne(n / 3, count + 1);
		
		if (n % 2 == 0) makeOne(n / 2, count + 1);
		
		makeOne(n - 1, count + 1);
		
	}
	
}