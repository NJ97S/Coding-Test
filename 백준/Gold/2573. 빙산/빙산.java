import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

/*
[문제 링크]
- https://www.acmicpc.net/problem/2573
*/

/*
[문제 정리]
- 1 초 / 256 MB

- 배열의 각 요소는 빙산의 높이 (바다는 0)
- 각 칸의 높이는 1년마다 해당 칸에 인접한 0 개수만큼 줄어든다. (0보다 작아질 수는 없다)

- 이차원 배열의 끝부분에 해당하는 값들은 항상 0

- 한 덩어리의 빙산이 주어질 때, 두 덩어리 이상으로 분리되는 최초의 시간(년) 출력
- 전부 녹을때까지 나누어지지 않으면, 0 출력
*/

/*
[풀이 방식]
- 각 요소에 인접한 0의 개수를 저장할 카운트 배열 필요
*/

public class Main {
	
	static BufferedReader br;
	
	static int N; // 이차원 배열 행 개수 (3 <= N <= 300)
	static int M; // 이차원 배열 열 개수 (3 <= M <= 300)
	
	static int[][] ICEBERG; // 각 빙산의 높이 (0 <= 높이 <= 10)
	
	static int[][] countOf0; // 각 요소에 인접한 0의 개수
	
	static int[] dr = {-1, 0, 1, 0}; // 북, 동, 남, 서
	static int[] dc = {0, 1, 0, -1};
	
	static boolean[][] visited;
	
	static int dayOfMelting;
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		ICEBERG = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			
			for (int j = 0; j < M; j++) {
				ICEBERG[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		// ------------------------ input ------------------------
		
		dayOfMelting = 0;
		
		countOf0 = new int[N][M];
		
		while (true) {
			dayOfMelting++;
			
			getCountOf0();
			meltIceberg();
			
			int numOfRegion = countRegion();
			
			if (numOfRegion == -1) dayOfMelting = 0;
			
			if (numOfRegion != 1) break;
		}
		
		System.out.println(dayOfMelting);
		
	}
	
	static void getCountOf0 () {
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				
				int count = 0;
				
				for (int k = 0; k < 4; k++) {
					int nr = r + dr[k];
					int nc = c + dc[k];
					
					if (nr < 0 || nr >= N || nc < 0 || nc >= M || ICEBERG[nr][nc] != 0) continue;
					
					count++;
				}
				
				countOf0[r][c] = count;
				
			}
		}
		
	}
	
	static void meltIceberg () {
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				
				if (ICEBERG[r][c] == 0) continue;
				
				int diff = ICEBERG[r][c] - countOf0[r][c];
				
				ICEBERG[r][c] = diff > 0 ? diff : 0;
				
			}
		}
		
	}
	
	static int countRegion () {
		
		int count = 0; // dfs 탐색 횟수 = 영역의 개수
		
		visited = new boolean[N][M];
		
		rowLoop:
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				
				if (ICEBERG[r][c] == 0 || visited[r][c]) continue;
				
				count++;
				if (count > 1) break rowLoop;
				
				dfs(r, c);
			}
		}
		
		return count > 0 ? count : -1; // count가 1 이상이 아니라면 (= 빙산이 없다면) -1 반환
		
	}
	
	static void dfs (int r, int c) {
		
		Stack<int[]> stack = new Stack<>();
		
		stack.add(new int[] {r, c});
		visited[r][c] = true;
		
		while (!stack.isEmpty()) {
			
			int[] curr = stack.pop();
			
			for (int k = 0; k < 4; k++) {
				int nr = curr[0] + dr[k];
				int nc = curr[1] + dc[k];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || ICEBERG[nr][nc] == 0) continue;
				
				stack.add(new int[] {nr, nc});
				visited[nr][nc] = true;
			}
			
		}
		
	}
	
}