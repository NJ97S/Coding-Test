import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		final int T = sc.nextInt();
		
		for (int testCase = 1; testCase <= T; testCase++) {
			final int N = sc.nextInt();
			final int M = sc.nextInt();
			
			final int[][] INPUT = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					INPUT[i][j] = sc.nextInt();
				}
			}
			
			int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1}; // 북쪽부터 시계 방향
			int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
			
			int answer = 0;
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					int countPFlies = INPUT[r][c];
					int countXFlies = INPUT[r][c];
					
					for (int k = 1; k < M; k++) {
						for (int m = 0; m < 8; m ++) {
							int nr = r + k * dr[m];
							int nc = c + k * dc[m];
							
							if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
							
							if (m % 2 == 0) countPFlies += INPUT[nr][nc];
							else countXFlies += INPUT[nr][nc];
						}
					}
					
					int bigger = Math.max(countPFlies, countXFlies);
					
					answer = Math.max(answer, bigger);
				}
			}
			
			System.out.printf("#%d %d\n", testCase, answer);
		}
		
		sc.close();

	}

}
