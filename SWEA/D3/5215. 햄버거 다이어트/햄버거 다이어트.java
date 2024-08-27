import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
- 칼로리 이하의 조합 중 -> 민기가 가장 선호하는 햄버거 조합
- 단순 조합 (중복 X)
*/

public class Solution {
	
	static BufferedReader br;
	static StringBuilder sb;
	
	static int N; // 재료의 수 (1 <= N <= 20)
	static int L; // 제한 칼로리 (1 <= L <= 10^4)
	
	static int[] SCORES; // 재료에 대한 점수 (1 <= score <= 10^3)
	static int[] CALORIES; // 재료에 대한 칼로리 (1 <= calorie <= 10^3)
	
	static int answer; // 주어진 제한 칼로리 이하의 조합 중 가장 높은 햄버거 점수
	
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
			
			answer = 0;
			
			loop:
			for (int i = 1; i < (1 << N); i++) {
				int tempScore = 0;
				int tempCalorie = 0;
				
				for (int j = 0; j < N; j++) {
					if ((i & (1 << j)) != 0) {
						tempScore += SCORES[j];
						tempCalorie += CALORIES[j];
						
						if (tempCalorie > L) continue loop;
					}
				}
				
				answer = Math.max(answer, tempScore);
			}
			
			sb.append(answer).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
}