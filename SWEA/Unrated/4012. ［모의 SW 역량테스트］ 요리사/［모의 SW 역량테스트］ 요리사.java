import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	
	static BufferedReader br;
	static StringBuilder sb;
	
	static int N; // 식재료 개수 (4 <= N <= 16)
	
	static int[][] SYNERGE; // 음식 간의 시너지 점수 (1 <= score <= 20,000)
	
	static int[] selected; // 선택한 음식
	
	static int answer; // 최소가 되는 두 음식 맛의 차
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		final int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");
			
			N = Integer.parseInt(br.readLine());
			
			SYNERGE = new int[N][N];
			for (int r = 0; r < N; r++) {
				String[] input = br.readLine().split(" ");
				for (int c = 0; c < N; c++) {
					SYNERGE[r][c] = Integer.parseInt(input[c]);
				}
			}
			
			answer = Integer.MAX_VALUE;
			
			selected = new int[N / 2];
			combination(0, 0);
			
			sb.append(answer).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	static void combination(int idx, int sIdx) {
		if (sIdx >= N / 2) {
			int[] food1 = new int[N / 2];
			int idx1 =0;
			
			int[] food2 = new int[N / 2];
			int idx2 = 0;
			
			int tempIdx = 0;
			for (int i = 0; i < N; i++) {
				if (tempIdx >= N / 2) {
					food2[idx2++] = i;
					continue;
				}
				
				if (selected[tempIdx] == i) {
					food1[idx1++] = i;
					tempIdx++;
				} else {
					food2[idx2++] = i;
				}
			}
			
			int diffScore = Math.abs(getFoodScore(food1) - getFoodScore(food2));
			
			answer = Math.min(answer, diffScore);
			
			return;
		}
		
		if (idx >= N) return;
		
		selected[sIdx] = idx;
		combination(idx + 1, sIdx + 1);
		combination(idx + 1, sIdx);
	}
	
	static int getFoodScore(int[] food) {
		int score = 0;
		
		for (int i: food) {
			for (int j: food) {
				score += SYNERGE[i][j];
			}
		}
		
		return score;
	}
	
}