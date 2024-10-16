import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
[문제 링크]
- https://www.acmicpc.net/problem/2638
*/

/*
[문제 정리]
- 1 초 / 128 MB

- 상하좌우 중 2면 이상이 공기이면, 한 시간 뒤 치즈가 녹아 사라진다.
- 치즈 내부에 있는 공간은 공기와 접촉하지 않는다고 가정한다.

- 맨 가장자리에 치즈가 놓이는 경우는 없다.

- 주어진 치즈가 모두 녹아 없어지는데 걸리는 시간 출력
*/

/*
[풀이 방식]
- input 받을 때, 치즈의 개수 미리 저장

- (0, 0)부터 bfs 탐색 -> 외부 공기 있는 곳 boolean 배열로 저장
- 외부 공기의 개수를 탐색 -> int 배열로 저장
- 외부 공기의 개수가 2 이상인 치즈 제거

- 치즈의 개수가 0이 될 때까지 반복
*/

public class Main {
	
	static BufferedReader br;
	
	static int N; // 모눈종이 세로 길이 (5 <= N <= 100)
	static int M; // 모눈종이 가로 길이 (5 <= M <= 100)
	
	static int[][] PAPER; // 모눈종이
	
	static int countOfCheese; // 남은 치즈의 수
	
	static int[] dr = {-1, 0, 1, 0}; // 북, 동, 남, 서
	static int[] dc = {0, 1, 0, -1};
	
	static boolean[][] visited; // 외부 공기 존재 여부
	
	static int[][] countOfOuterAir; // 치즈 주변의 외부 공기 수
	
	static int hourOfMelted; // 치즈가 모두 없어지는 데 걸리는 시간
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		PAPER = new int[N][M];
		
		countOfCheese = 0;
		
		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			
			for (int j = 0; j < M; j++) {
				int elem = Integer.parseInt(input[j]);
				
				PAPER[i][j] = elem;
				
				if (elem == 1) countOfCheese++;
			}
		}
		
		// ----------------------- input -----------------------
		
		hourOfMelted = 0;
		
		countOfOuterAir = new int[N][M];
		
		while (countOfCheese > 0) {
			
			hourOfMelted++;
			
			searchOuterAir();
			getCountOfOuterAir();
			meltCheese();
			
		}
		
		System.out.println(hourOfMelted);
		
	}
	
	static void searchOuterAir() {
		
		visited = new boolean[N][M];
		
		Queue<int[]> queue = new LinkedList<>();
		
		queue.add(new int[] {0, 0});
		visited[0][0] = true;
		
		while (!queue.isEmpty()) {
			
			int[] curr = queue.poll();
			
			for (int k = 0; k < 4; k++) {
				int nr = curr[0] + dr[k];
				int nc = curr[1] + dc[k];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || PAPER[nr][nc] == 1) continue;
				
				queue.add(new int[] {nr, nc});
				visited[nr][nc] = true;
			}
			
		}
		
	}
	
	static void getCountOfOuterAir() {
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				
				if (PAPER[r][c] == 0) continue;
				
				int count = 0; // 인접한 외부 공기의 수
				
				for (int k = 0; k < 4; k++) {
					int nr = r + dr[k];
					int nc = c + dc[k];
					
					if (visited[nr][nc]) count++;
				}
				
				countOfOuterAir[r][c] = count;
				
			}
		}
		
	}
	
	static void meltCheese() {
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				
				if (PAPER[r][c] == 0 || countOfOuterAir[r][c] < 2) continue;
				
				PAPER[r][c] = 0;
				countOfCheese--;
				
			}
		}
		
	}
	
}