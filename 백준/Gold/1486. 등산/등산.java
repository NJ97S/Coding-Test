import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

/*
[문제 링크]
- https://www.acmicpc.net/problem/1486
*/

/*
[문제 정리]
- 2 초 / 128 MB

- 지도에 높이가 표시됨
  - A = 0  |  Z = 25
  - a = 26 |  z = 51

- 인접한 좌표 중, 높이의 차이가 T보다 크지 않은 곳으로만 이동 가능

- 이동할 높이 <= 현재 높이  -> 1초
- 이동할 높이 > 현재 높이   -> 두 높이 차이의 제곱

- 어두워지는 시간까지 올라갈 수 있는 최대 높이 구하기 (호텔 --(등산)--> 호텔)
*/

/*
[풀이 방식]
- 시간을 가중치로 생각 -> 유향 그래프 -> 다익스트라
*/

public class Main {
	
	static class Node implements Comparable<Node> {

		int r, c, time;
		
		public Node(int r, int c, int time) {
			
			this.r = r;
			this.c = c;
			this.time = time;
			
		}

		@Override
		public int compareTo(Main.Node o) {
			
			return this.time - o.time;
			
		}
		
	}
	
	static BufferedReader br;
	
	static int N; // 산의 세로 크기 (1 <= N <= 25)
	static int M; // 산의 가로 크기 (1 <= M <= 25)
	
	static int T; // 이동 가능한 높이 차이 (1 <= T <= 52)
	
	static int D; // 어두워지는 시간 (1 <= D <= 1,000,000)
	
	static int[][] MAP;
	
	static int[][] timeGo;
	static int[][] timeReturn;
	
	static int[] dr = {-1, 0, 1, 0}; // 북, 동, 남, 서
	static int[] dc = {0, 1, 0, -1};
	
	static int maxHeight;
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		T = Integer.parseInt(input[2]);
		
		D = Integer.parseInt(input[3]);
		
		MAP = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			input = br.readLine().split("");
			
			for (int j = 0; j < M; j++) {
				char elem = input[j].charAt(0);
				
				if (elem >= 'A' && elem <= 'Z') MAP[i][j] = elem - 'A';
				else MAP[i][j] = elem - 'a' + 26;
			}
		}
		
		// ------------------------- input -------------------------
		
		maxHeight = 0;
		
		timeGo = new int[N][M];
		timeReturn = new int[N][M];
		
		dijkstra(0, 0);
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				
				if (timeGo[r][c] > D) continue;
				
				int returnTime = dijkstraReturn(r, c);
				
				if (timeGo[r][c] + returnTime <= D) maxHeight = Math.max(maxHeight, MAP[r][c]);
				
			}
		}
		
		System.out.println(maxHeight);
		
	}

	static void dijkstra(int r, int c) {

		for (int i = 0; i < N; i++) {
			Arrays.fill(timeGo[i], Integer.MAX_VALUE);
		}
		
		PriorityQueue<Node> queue = new PriorityQueue<>();
		
		queue.add(new Node(r, c, 0));
		timeGo[r][c] = 0;
		
		while (!queue.isEmpty()) {
			
			Node curr = queue.poll();
			
			if (curr.time > timeGo[curr.r][curr.c]) continue;
			
			for (int k = 0; k < 4; k++) {
				int nr = curr.r + dr[k];
				int nc = curr.c + dc[k];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				
				int diffHeight = Math.abs(MAP[nr][nc] - MAP[curr.r][curr.c]);
				
				if (diffHeight > T) continue;
				
				int cost = MAP[nr][nc] > MAP[curr.r][curr.c] ? diffHeight * diffHeight : 1;
				
				if (timeGo[nr][nc] > timeGo[curr.r][curr.c] + cost) {
					timeGo[nr][nc] = timeGo[curr.r][curr.c] + cost;
					queue.add(new Node(nr, nc, timeGo[nr][nc]));
				}
			}
			
		}
		
	}
	
	static int dijkstraReturn(int r, int c) {
		
		for (int i = 0; i < N; i++) {
			Arrays.fill(timeReturn[i], Integer.MAX_VALUE);
		}
		
		PriorityQueue<Node> queue = new PriorityQueue<>();
		
		queue.add(new Node(r, c, 0));
		timeReturn[r][c] = 0;
		
		while (!queue.isEmpty()) {
			
			Node curr = queue.poll();
			
			if (curr.r == 0 && curr.c == 0) return timeReturn[0][0]; // 우선순위 큐이기 때문에, 출발점 뽑으면 바로 return
			
			if (curr.time > timeReturn[curr.r][curr.c]) continue;
			
			for (int k = 0; k < 4; k++) {
				int nr = curr.r + dr[k];
				int nc = curr.c + dc[k];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				
				int diffHeight = Math.abs(MAP[nr][nc] - MAP[curr.r][curr.c]);
				
				if (diffHeight > T) continue;
				
				int cost = MAP[nr][nc] > MAP[curr.r][curr.c] ? diffHeight * diffHeight : 1;
				
				if (timeReturn[nr][nc] > timeReturn[curr.r][curr.c] + cost) {
					timeReturn[nr][nc] = timeReturn[curr.r][curr.c] + cost;
					queue.add(new Node(nr, nc, timeReturn[nr][nc]));
				}
			}
			
		}
		
		return -1;
		
	}
	
}