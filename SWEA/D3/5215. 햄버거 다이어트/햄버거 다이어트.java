import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	
	static BufferedReader br;
	static StringBuilder sb;
	
	static int N; // 재료의 개수
	static int L; // 제한 칼로리
	
	static int[] scores;
	static int[] cals;
	
	static int answer;
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");  
			
			String[] input = br.readLine().split(" ");
			N = Integer.parseInt(input[0]);
			L = Integer.parseInt(input[1]);
			
			scores = new int[N];
			cals = new int[N];
			
			for (int i = 0; i < N; i++) {
				input = br.readLine().split(" ");
				
				scores[i] = Integer.parseInt(input[0]);
				cals[i] = Integer.parseInt(input[1]);
			}
			
			answer = 0;
			makeBurger(0, 0, 0);
			
			sb.append(answer).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	static void makeBurger(int idx, int sumScore, int sumCal) {
		if (sumCal > L) return;
		
		if (idx >= N) {
			answer = Math.max(answer, sumScore);
			return;
		}
		
		makeBurger(idx + 1, sumScore + scores[idx], sumCal + cals[idx]);
		makeBurger(idx + 1, sumScore, sumCal);
	}
	
}