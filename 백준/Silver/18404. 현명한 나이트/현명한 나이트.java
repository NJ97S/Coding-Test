import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
[문제 정리]
- 1초 / 256MB

- N * N 체스판
- 상대편 말 M개
- 상대편 말을 잡기 위한 나이트의 최소 이동 수 계산
*/

public class Main {

    static BufferedReader br;
    static StringBuilder sb;

    static int N; // 체스판 크기 (1 <= N <= 500)
    static int M; // 상대편 말 개수 (1 <= M <= 1,000)

    static int[] NIGHT; // 나이트 위치
    static int[] TARGET; // 상대편 말 위치

    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

    static boolean[][] visited;

    static int[][] dist; // 출발점에서 도달하기까지 걸리는 이동 횟수

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        String[] input = br.readLine().split(" ");

        N =  Integer.parseInt(input[0]);
        M =  Integer.parseInt(input[1]);

        NIGHT = new int[2];
        TARGET = new int[2];

        input =  br.readLine().split(" ");

        NIGHT[0] =  Integer.parseInt(input[0]);
        NIGHT[1] =  Integer.parseInt(input[1]);

        visited = new boolean[N + 1][N + 1];
        dist = new int[N + 1][N + 1];

        bfs();

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");

            TARGET[0] =  Integer.parseInt(input[0]);
            TARGET[1] =  Integer.parseInt(input[1]);

            sb.append(dist[TARGET[0]][TARGET[1]]).append(" ");
        }

        System.out.println(sb.toString().trim());

    }

    static void bfs() {

        Queue<int[]> queue = new LinkedList<>();

        queue.add(NIGHT);
        visited[NIGHT[0]][NIGHT[1]] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            int cx = curr[0];
            int cy = curr[1];

            for (int k = 0; k < 8; k++) {
                int nx = cx + dx[k];
                int ny = cy + dy[k];

                if (nx <= 0 || nx > N || ny <= 0 || ny > N || visited[nx][ny]) continue;

                queue.add(new int[] {nx, ny});

                visited[nx][ny] = true;
                dist[nx][ny] = dist[cx][cy] + 1;
            }
        }

    }

}