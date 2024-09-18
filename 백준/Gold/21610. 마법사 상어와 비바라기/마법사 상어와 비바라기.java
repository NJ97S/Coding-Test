import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
[문제 링크]
- https://www.acmicpc.net/problem/21610
*/

/*
[문제 정리]
- 1 초 / 1024 MB

- N * N 크기의 격자, 각 칸에 바구니 있음.
- 바구니에 저장할 수 있는 물의 양 제한 없음.

- 비바라기 시전하면, (N, 1), (N, 2), (N-1, 1), (N-1, 2)에 비구름 생김

- 구름이 M번 이동 (방향, 거리 주어짐)
  1. 모든 구름이 해당 방향으로 주어진 거리만큼 이동
  2. 구름이 있는 칸의 바구니에 저장된 물의 양 +1
  3. 구름 사라짐
  4. 물이 증가한 칸에 물복사 마법 시전 => 대각선 방향으로 거리가 1인 칸에 물이 있는 바구니 수만큼, 해당 칸의 물의 양 증가
     - 경계를 넘어가는 칸은 제외
  5. 바구니의 물의 양 >= 2 을 만족하는 모든 칸에 구름이 생기고, 물의 양 -2
     - 단, 3에서 구름이 사라진 칸은 제외
 
 - M번의 이동이 끝난 후, 바구니에 들어있는 물의 총합 출력
*/

public class Main {
	
	static BufferedReader br;
	
	static int N; // 격자 크기 (2 <= N <= 50)
	static int M; // 이동 횟수 (1 <= M <= 100)
	
	static int[][] MAP;
	static boolean[][] hasCloud; // 구름 존재 여부
	
	static int[] dr = {0, -1, -1, -1, 0, 1, 1, 1}; // ←, ↖, ↑, ↗, →, ↘, ↓, ↙
	static int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		MAP = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			
			for (int j = 0; j < N; j++) {
				MAP[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		hasCloud = new boolean[N][N];
		
		// 비바라기 시전 직후, 구름 위치 입력
		hasCloud[N - 1][0] = true;
		hasCloud[N - 1][1] = true;
		hasCloud[N - 2][0] = true;
		hasCloud[N - 2][1] = true;
		
		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			
			int direction = Integer.parseInt(input[0]) - 1; // 이동 방향 (dr, dc 배열의 인덱스가 0부터 시작하기 때문에, 1 빼줌)
			int move = Integer.parseInt(input[1]); // 이동 횟수
			
			moveCloud(direction, move);
			
			rain();
			
			waterCopy();
			
			makeNewCloudAndRemoveWater();
		}
		
		System.out.println(getAmountOfWater());
		
	}
	
	static void moveCloud(int direction, int move) {
		
		boolean[][] nextCloud = new boolean[N][N];
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				
				if (!hasCloud[r][c]) continue; // 구름이 없는 곳은 continue
				
				// 음수인 경우를 고려하여, 충분히 큰 수를 더해준 뒤, 나머지 구함
				// M이 최대 100이고, N이 최소 2이므로, 51 * N이면 모든 범위를 대응할 수 있음.
				int nr = (r + move * dr[direction] + 51 * N) % N;
				int nc = (c + move * dc[direction] + 51 * N) % N;
				
				nextCloud[nr][nc] = true;
				
			}
		}
		
		hasCloud = nextCloud;
		
	}
	
	static void rain() {
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				
				if (!hasCloud[r][c]) continue;
				
				MAP[r][c]++;
			}
		}
		
	}
	
	static void waterCopy() {
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				
				if (!hasCloud[r][c]) continue;
				
				MAP[r][c] += getCountDiagonalCloud(r, c);
			}
		}
		
	}
	
	static int getCountDiagonalCloud (int r, int c) {
		
		int count = 0;
		
		for (int k = 1; k < 8; k += 2) {
			int nr = r + dr[k];
			int nc = c + dc[k];
			
			// 범위를 벗어나거나 물이 없으면, continue
			if (nr < 0 || nr >= N || nc < 0 || nc >= N || MAP[nr][nc] == 0) continue;
			
			count++;
		}
		
		return count;
		
	}
	
	static void makeNewCloudAndRemoveWater () {
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				
				if (hasCloud[r][c]) {
					hasCloud[r][c] = false;
					continue;
				}
				
				if (MAP[r][c] < 2) continue;
				
				MAP[r][c] -= 2;
				hasCloud[r][c] = true;
				
			}
		}
		
	}
	
	static int getAmountOfWater() {
		
		int count = 0;
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				
				count += MAP[r][c];
				
			}
		}
		
		return count;
		
	}
	
}