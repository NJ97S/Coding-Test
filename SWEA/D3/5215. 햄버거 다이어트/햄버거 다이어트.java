import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	
	static BufferedReader br;
	static StringBuilder sb;
	
	static int N; // 재료의 수 (1 <= N <= 20)
	static int L; // 제한 칼로리 (1 <= L <= 10^4)
	
	static int[] SCORES; // 재료 점수
	static int[] CALORIES; // 재료 칼로리
	static boolean[] selected; // 사용한 재료
	
	static int answer; // 가장 높은 햄버거 점수
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		final int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");
			
			String[] input = br.readLine().split(" ");
			N = Integer.parseInt(input[0]);
			L = Integer.parseInt(input[1]);
			
			SCORES = new int[N];
			CALORIES = new int[N];
			
			for (int i = 0; i < N; i++) {
				input = br.readLine().split(" ");
				
				SCORES[i] = Integer.parseInt(input[0]);
				CALORIES[i] = Integer.parseInt(input[1]);
			}
			
			selected = new boolean[N];
			
			answer = 0;
			powerset(0);
			
			sb.append(answer).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	static void powerset(int idx) {
		if (idx >= N) {
			int score = 0;
			int calorie = 0;
			
			for (int i = 0; i < N; i++) {
				if (selected[i]) {
					score += SCORES[i];
					calorie += CALORIES[i];
				}
				
				if (calorie > L) return;
			}
			
			answer = Math.max(answer, score);
			
			return;
		}
		
		selected[idx] = true;
		powerset(idx + 1);
		
		selected[idx] = false;
		powerset(idx + 1);
	}
	
}