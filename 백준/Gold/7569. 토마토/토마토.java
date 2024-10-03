import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
[문제 링크]
- https://www.acmicpc.net/problem/7569
*/

/*
[문제 정리]
- 1 초 / 256 MB

- 익은 토마토에 인접한 토마토들이 하루 단위로 익음

- 토마토가 익는 최소 일수 구하기
*/

public class Main {
	
	static BufferedReader br;
	static StringBuilder sb;
	
	static int N; // 상자의 세로 길이
	static int M; // 상자의 가로 길이
	static int H; // 상자의 수
	
	static int[][][] TOMATOES;
	
	static int[] dr = {-1, 0, 1, 0, 0, 0}; // 북, 동, 남, 서, 위, 아래
	static int[] dc = {0, 1, 0, -1, 0, 0};
	static int[] dh = {0, 0, 0, 0, -1, 1};
	
	static boolean[][][] visited;
	
	static int minDay;
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		String[] input = br.readLine().split(" ");
		
		M = Integer.parseInt(input[0]);
		N = Integer.parseInt(input[1]);
		H = Integer.parseInt(input[2]);
		
		TOMATOES = new int[H][N][M];
		
		for (int h = 0; h < H; h++) {
			
			for (int i = 0; i < N; i++) {
				input = br.readLine().split(" ");
				
				for (int j = 0; j < M; j++) {
					TOMATOES[h][i][j] = Integer.parseInt(input[j]);
				}
			}
			
		}
		
		// ------------------------ input ------------------------
		
		minDay = 0;
		
		ripenTomatoes();
		
		System.out.println(hasUnripeTomato() ? -1 : minDay);
		
	}
	
	static void ripenTomatoes() {
		
		Queue<int[]> queue = new LinkedList<>();
		
		visited = new boolean[H][N][M];
		
		for (int h = 0; h < H; h++) {
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					
					if (TOMATOES[h][r][c] != 1 || visited[h][r][c]) continue;
					
					queue.add(new int[] {h, r, c, 0});
					visited[h][r][c] = true;
					
				}
			}
		}
		
		bfs(queue);
		
	}
	
	static void bfs(Queue<int[]> queue) {
		
		while (!queue.isEmpty()) {
			
			int[] curr = queue.poll();
			
			for (int k = 0; k < 6; k++) {
				int nh = curr[0] + dh[k];
				int nr = curr[1] + dr[k];
				int nc = curr[2] + dc[k];
				
				int day = curr[3];
				
				if (nh < 0 || nh >= H || nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nh][nr][nc] || TOMATOES[nh][nr][nc] != 0) continue;
				
				queue.add(new int[] {nh, nr, nc, ++day});
				visited[nh][nr][nc] = true;
				
				TOMATOES[nh][nr][nc] = 1;
				
				minDay = Math.max(minDay, day);
			}
			
		}
		
	}
	
	static boolean hasUnripeTomato() {
		
		for (int h = 0; h < H; h++) {
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					
					if (TOMATOES[h][r][c] == 0) return true;
					
				}
			}
		}
		
		return false;
		
	}
	
}