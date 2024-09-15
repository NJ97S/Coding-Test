import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
	
	static BufferedReader br;
	static StringBuilder sb;
	
	static int M; // 배추밭 가로 길이 (1 <= M <= 50)
	static int N; // 배추밭 세로 길이 (1 <= N <= 50)
	
	static int K; // 배추가 심어져 있는 위치 개수 (1 <= K <= 2,500)
	static int[][] MAP; // 배추 위치
	
	static int[] dr = {-1, 0, 1, 0}; // 북, 동, 남, 서
	static int[] dc = {0, 1, 0, -1};
	
	static boolean[][] visited;
	
	static int count; // 영역 카운트
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		final int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			String[] input = br.readLine().split(" ");
			M = Integer.parseInt(input[0]);
			N = Integer.parseInt(input[1]);
			
			K = Integer.parseInt(input[2]);
			
			MAP = new int[N][M];
			
			for (int i = 0; i < K; i++) {
				input = br.readLine().split(" ");
				
				MAP[Integer.parseInt(input[1])][Integer.parseInt(input[0])] = 1;
			}
			
			// -------------------------- input --------------------------
			
			count = 0;
			
			visited = new boolean[N][M];
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					
					if (visited[r][c] || MAP[r][c] != 1) continue; // 방문했던 곳이거나, 배추가 심어져 있는 곳이 아니라면, continue
					
					countRegion(r, c);
					
					count++; // DFS 한 번 다 돌면, 영역 체크가 끝났다는 말이기 때문에, count를 1 올려줌
					
				}
			}
			
			sb.append(count).append("\n");
			
		}
		
		System.out.println(sb);
		
	}
	
	static void countRegion(int r, int c) {
		
		Stack<int[]> stack = new Stack<>();
		
		stack.add(new int[] {r, c});
		visited[r][c] = true;
		
		while (!stack.isEmpty()) {
			
			int[] curr = stack.pop();
			
			for (int k = 0; k < 4; k++) {
				int nr = curr[0] + dr[k];
				int nc = curr[1] + dc[k];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= M || MAP[nr][nc] != 1 || visited[nr][nc]) continue; // 범위 벗어나거나 방문한 곳이면, continue
				
				stack.add(new int[] {nr, nc});
				visited[nr][nc] = true;
			}
			
		}
		
	}
	
}