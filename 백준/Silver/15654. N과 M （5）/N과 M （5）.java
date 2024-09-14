import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
[문제 링크]
- https://www.acmicpc.net/problem/15654
*/

/*
[문제 정리]
- 1 초 / 512 MB

- N개의 자연수
- 만들어야 하는 수열의 길이 M

- 다음 조건을 만족하는 길이가 M인 수열 모두 출력
  1. N개의 자연수 중에서 M개를 고른 수열
*/

public class Main {
	
	static BufferedReader br;
	static StringBuilder sb;
	
	static int N; // 1 <= M <= N <= 8
	static int M;
	
	static int[] NUMBERS;
	
	static int[] selected;
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		NUMBERS = new int[N];
		
		input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			NUMBERS[i] = Integer.parseInt(input[i]);
		}
		
		// ----------------------- input -----------------------

		Arrays.sort(NUMBERS);
		
		selected = new int[M];
		perm(0, 0);
		
		System.out.println(sb);
		
	}
	
	static void perm(int idx, int visited) {
		
		// 기저 조건
		if (idx == M) {
			for (int num: selected) sb.append(num).append(" ");
			sb.append("\n");
			
			return;
		}
		
		// 재귀 부분
		for (int i = 0; i < N; i++) {
			
			if ((visited & (1 << i)) != 0) continue;
			
			selected[idx] = NUMBERS[i];
			perm(idx + 1, visited | 1 << i);
			
		}
		
	}
	
}