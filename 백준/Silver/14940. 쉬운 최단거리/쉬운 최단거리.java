import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static BufferedReader br;
	static StringBuilder sb;
	
	static int N; // 지도의 세로 길이
	static int M; // 지도의 가로 길이
	
	static int[][] MAP;
	static int[] END; // 도착지점의 좌표
	
	static int[][] dist;
	
	static int[] dr = {-1, 0, 1, 0}; // 북, 동, 남, 서
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		String[] input = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		MAP = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			
			for (int j = 0; j < M; j++) {
				int elem = Integer.parseInt(input[j]);
				
				MAP[i][j] = elem;
				
				if (elem == 2) END = new int[] {i, j};
			}
		}
		
		// -------------------------- input --------------------------
		
		dist = new int[N][M];
		
		bfs(END[0], END[1]);
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				// 거리가 0이면서 기존 값이 0이 아니고 && 도착 지점이 아니면 -> -1 출력
				sb.append(dist[r][c] == 0 && MAP[r][c] != 0 && (r != END[0] || c != END[1]) ? -1 : dist[r][c]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	static void bfs(int r, int c) {
		
		Queue<int[]> queue = new LinkedList<>();
		
		queue.add(new int[] {r, c});
		
		while (!queue.isEmpty()) {
			
			int[] curr = queue.poll();
			
			for (int k = 0; k < 4; k++) {
				int nr = curr[0] + dr[k];
				int nc = curr[1] + dc[k];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= M || dist[nr][nc] > 0 || MAP[nr][nc] != 1) continue;
				
				queue.add(new int[] {nr, nc});
				dist[nr][nc] = dist[curr[0]][curr[1]] + 1;
			}
			
		}
		
	}
	
}