import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
[문제 정리]
- 2초 / 192MB

- (N * M) 크기의 맵
- (1, 1) -> (N, M)으로 이동하는 최단 거리
- 벽 1개 부술 수 있음

- (1, 1)과 (N, M)은 항상 0
- 시작칸과 끝칸도 카운트에 포함

- 이동 불가능하면 -1 출력
*/

public class Main {

    static BufferedReader br;

    static int N; // 맵의 행 크기 (1 <= N <= 1,000)
    static int M; // 맵의 열 크기 (1 <= M <= 1,000)

    static final int EMPTY = 0;
    static final int WALL = 1;

    static int[][] MAP;

    static boolean[][][] visited;

    static int[] dr = {-1, 0, 1, 0}; // 북, 동, 남, 서
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        MAP = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1][2];

        for (int i = 1; i <= N; i++) {
            input = br.readLine().split("");

            for (int j = 1; j <= M; j++) {
                MAP[i][j] = Integer.parseInt(input[j - 1]);
            }
        }

        // ------------------------ input ------------------------

        System.out.println(bfs());

    }

    static int bfs() {

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[] {1, 1, 1, 0}); // (행, 열, 거리, 벽 부쉈는지)
        visited[1][1][0] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            if (curr[0] == N && curr[1] == M) return curr[2];

            for (int i = 0; i < 4; i++) {
                int nr = curr[0] + dr[i];
                int nc = curr[1] + dc[i];

                int currDist = curr[2];
                int isBroken = curr[3];

                if (nr < 1 || nr > N || nc < 1 || nc > M) continue;

                if (MAP[nr][nc] == EMPTY && !visited[nr][nc][isBroken]) {
                    queue.add(new int[]{nr, nc, currDist + 1, isBroken});
                    visited[nr][nc][isBroken] = true;
                }

                if (MAP[nr][nc] == WALL && isBroken == 0 && !visited[nr][nc][1]) {
                    queue.add(new int[]{nr, nc, currDist + 1, 1});
                    visited[nr][nc][1] = true;
                }
            }
        }

        return -1;

    }

}
