import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
	
	static BufferedReader br;
	static StringBuilder sb;
	
	static int N; // 치즈 한 변의 길이 (2 <= N <= 100)
	
	static int D; // 치즈 먹는 날
	
	static int[][] CHEESE;
	static boolean[][] visited;
	
	static int[] dr = {-1, 0, 1, 0}; // 북, 동, 남, 서
	static int[] dc = {0, 1, 0, -1};
	
	static int answer; // 가장 많은 치즈 덩어리 개수
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		final int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");
			
			N = Integer.parseInt(br.readLine());
			
			CHEESE = new int[N][N];
			D = 0;
			
			for (int i = 0; i < N; i++) {
				String[] input = br.readLine().split(" ");
				
				for (int j = 0; j < N; j++) {
					int elem = Integer.parseInt(input[j]);
					
					CHEESE[i][j] = elem;
					D = Math.max(D, elem);
				}
			}
			
			// ----------------------- input -----------------------
			
			int answer = 0;
			
			for (int day = 1; day < D; day++) {
				
				int numOfCheese = 0;
				
				visited = new boolean[N][N];
				
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						
						if (visited[r][c] || CHEESE[r][c] <= day) continue;
						
						dfs(day, r, c);
												
						numOfCheese++;
						
					}
				}
				
				answer = Math.max(answer, numOfCheese);
				
			}
			
			sb.append(answer == 0 ? 1 : answer).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	static void dfs(int day, int r, int c) {
		
		Stack<int[]> stack = new Stack<>();
		
		stack.push(new int[] {r, c});
		visited[r][c] = true;
		
		while (!stack.isEmpty()) {
			
			int[] cur = stack.pop();
			
			for (int k = 0; k < 4; k++) {
				int nr = cur[0] + dr[k];
				int nc = cur[1] + dc[k];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc] || CHEESE[nr][nc] <= day) continue;
				
				stack.push(new int[] {nr, nc});
				visited[nr][nc] = true;
			}
			
		}
		
	}
	
}