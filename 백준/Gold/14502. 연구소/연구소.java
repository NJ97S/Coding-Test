import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
[문제 링크]
- https://www.acmicpc.net/problem/14502
*/

/*
[문제 정리]
- 2 초 / 512 MB

- N * M 크기의 연구소
- 일부 칸에 존재하는 바이러스는, 상하좌우로 인접한 칸에 퍼질 수 있음.
- 반드시 3개의 벽을 세워야 함.

- 바이러스 = 2  | 벽 = 1  | 빈 칸 = 0

- 안전 영역 크기의 최댓값 출력
*/

/*
[풀이 방식]
- 모든 경우의 수를 구해야 함 -> 브루트 포스

- 바이러스와 인접한 칸에 하나씩 벽 세워보기
- 벽 개수 == 3 이면, 바이러스 퍼뜨리기
- 빈 공간의 개수 세기
*/

public class Main {
	
	static BufferedReader br;
	
	static int N; // 연구소 세로 길이 (3 <= N, M <= 8)
	static int M; // 연구소 가로 길이
	
	static int[][] MAP;
	
	static int[] dr = {-1, 0, 1, 0}; // 북, 동, 남, 서
	static int[] dc = {0, 1, 0, -1};
	
	static boolean[][] visited;
	
	static int[][] mapAfterSpreadVirus; // 바이러스가 퍼진 후의 지도
	
	static int maxNumOfSafetyArea; // 안전 영역 크기의 최댓값
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		MAP = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			
			for (int j = 0; j < M; j++) {
				MAP[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		// ---------------------- input ----------------------
		
		maxNumOfSafetyArea = 0;
		
		putWall(0);
		
		System.out.println(maxNumOfSafetyArea);
		
	}
	
	// count: 벽 개수
	static void putWall(int count) {
		
		// 기저 조건
		if (count == 3) {
			mapAfterSpreadVirus = new int[N][M];
			copyMap();
			
			spreadVirus(); // 바이러스 확산
			
			getNumOfSafetyArea(); // 안전 영역 계산
			
			return;
		}
		
		// 재귀 부분		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				
				if (MAP[r][c] != 0) continue;
				
				MAP[r][c] = 1;
				putWall(count + 1);
				
				MAP[r][c] = 0;
				
			}
		}
		
	}
	
	static void copyMap() {
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				mapAfterSpreadVirus[i][j] = MAP[i][j];
			}
		}
		
	}
	
	static void spreadVirus() {
		
		visited = new boolean[N][M];
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				
				if (visited[r][c] || mapAfterSpreadVirus[r][c] != 2) continue;
				
				bfs(r, c);
				
			}
		}
		
	}
	
	static void bfs(int r, int c) {
		
		Queue<int[]> queue = new LinkedList<>();
		
		queue.add(new int[] {r, c});
		visited[r][c] = true;
		
		mapAfterSpreadVirus[r][c] = 2;
		
		while (!queue.isEmpty()) {
			
			int[] curr = queue.poll();
			
			for (int k = 0; k < 4; k++) {
				int nr = curr[0] + dr[k];
				int nc = curr[1] + dc[k];
				
				// 범위를 벗어나거나, 빈 공간이 아니면, continue
				if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || MAP[nr][nc] != 0) continue;
				
				queue.add(new int[] {nr, nc});
				visited[nr][nc] = true;
				
				mapAfterSpreadVirus[nr][nc] = 2;
			}
			
		}
		
	}
	
	static void getNumOfSafetyArea () {
		
		int count = 0;
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				
				if (mapAfterSpreadVirus[r][c] == 0) count++;
				
			}
		}
		
		maxNumOfSafetyArea = Math.max(maxNumOfSafetyArea, count);
		
	}
	
}