import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
[풀이 방식]
- 범위가 정해져있지 않기 때문에, long 자료형 사용
- 시간 초과를 고려하여, memoization 적용
*/

public class Solution {
	
	static BufferedReader br;
	static StringBuilder sb;
	
	static int N;
	
	static long[] numOfFibonacci; // 피보나치 수 저장할 배열
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		for (int testCase = 1; testCase <= 5; testCase++) {
			N = Integer.parseInt(br.readLine());
			
			numOfFibonacci = new long[N + 1]; // 0번째 인덱스에 0을 넣기 위해, (N + 1) 크기의 배열로 생성
			
			numOfFibonacci[0] = 0;
			numOfFibonacci[1] = 1;
			
			if (N > 1) getNumOfFibonacci(N);
			
			sb.append(numOfFibonacci[N]).append("\n");
		}
		
		System.out.println(sb.toString().trim());
		
	}
	
	static void getNumOfFibonacci(int n) {
		
		for (int i = 2; i <= n; i++) {
			numOfFibonacci[i] = numOfFibonacci[i - 1] + numOfFibonacci[i - 2];
		}
		
	}
	
}