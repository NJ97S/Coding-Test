import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
	
	static BufferedReader br;
	static StringBuilder sb;
	
	static int N = 16; // 미로의 가로, 세로 길이
	
	static int[][] MAZE;
	
	static int[] START; // 출발점의 좌표
	static int[] END; // 끝점의 좌표
	
	static boolean[][] visited;
	
	static int[] dr = {-1, 0, 1, 0}; // 북 동 남 서
	static int[] dc = {0, 1, 0, -1};
	
	static int answer; // 도달 가능 여부
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		for (int testCase = 1; testCase <= 10; testCase++) {
			sb.append("#").append(br.readLine()).append(" ");
			
			MAZE = new int[N][N];
			for (int i = 0; i < N; i++) {
				String[] input = br.readLine().split("");
				
				for (int j = 0; j < N; j++) {
					int elem = Integer.parseInt(input[j]);
					
					MAZE[i][j] = elem;
					
					if (elem == 2) START = new int[] {i, j};
					else if (elem == 3) END = new int[] {i, j};
				}
			}
			
			answer = 0;
			
			visited = new boolean[N][N];		
			
			dfs(START[0], START[1]);
			
			sb.append(answer).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	static void dfs(int r, int c) {
		
		Stack<int[]> stack = new Stack<>();
		
		stack.push(new int[] {r, c});
		visited[r][c] = true;
		
		while (!stack.isEmpty()) {
			
			int[] cur = stack.pop();
			
			for (int k = 0; k < 4; k++) {
				int nr = cur[0] + dr[k];
				int nc = cur[1] + dc[k];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc] || MAZE[nr][nc] == 1) continue;
				
				if (MAZE[nr][nc] == 3) {
					answer = 1;
					return;
				}
				
				stack.push(new int[] {nr, nc});
				visited[nr][nc] = true;
			}
			
		}
		
	}
	
}