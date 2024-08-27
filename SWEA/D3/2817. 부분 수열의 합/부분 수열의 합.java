import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	
	static BufferedReader br;
	static StringBuilder sb;
	
	static int N; // 자연수의 개수 (1 <= N <= 20)
	static int K; // 만들어야 하는 합 (1 <= K <= 1,000)
	
	static int[] NUMBERS; // 자연수
	static boolean[] selected; // 자연수 선택 여부
	
	static int answer; // 최소 1개 이상의 수를 선택하여, 그 합이 K가 되는 경우의 수
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		final int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");
			
			String[] input = br.readLine().split(" ");
			N = Integer.parseInt(input[0]);
			K = Integer.parseInt(input[1]);
			
			NUMBERS = new int[N];
			
			input = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				NUMBERS[i] = Integer.parseInt(input[i]);
			}
			
			answer = 0;
			
			selected = new boolean[N];
			powerset(0);
			
			sb.append(answer).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	static void powerset(int idx) {
		if (idx >= N) {
			int sum = 0;
			
			for (int i = 0; i < N; i++) {
				if (selected[i]) sum += NUMBERS[i];
				
				if (sum > K) return;
			}
			
			if (sum == K) answer++;
			
			return;
		}
		
		selected[idx] = true;
		powerset(idx + 1);
		
		selected[idx] = false;
		powerset(idx + 1);
	}
	
}