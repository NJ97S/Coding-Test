import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
[문제 정리]
- 2초 / 512MB

- 청소하는 영역의 개수 구하기

- 방의 크기는 N * M
- 각 칸은 벽(1) or 빈 칸(0)

- 처음 빈 칸은 전부 청소되지 않은 상태

- 로봇 청소기 방향 d
    - 0: 북쪽 / 1: 동쪽 / 2: 남쪽 / 3: 서쪽

- 로봇 청소기 작동 규칙
    1. 현재 칸이 청소되지 않은 경우 -> 현재 칸 청소
    2. 현재 칸의 주변 4칸 중 청소되지 않은 빈칸이 없는 경우
        1) 바라보는 방향 유지하고 한 칸 후진 가능하면, 후진 후 1번으로
        2) 후진 못하면 작동 STOP
    3. 현재 칸의 주변 4칸 중 청소되지 않은 빈칸이 있는 경우
        1) 반시계 방향으로 90도 회전
        2) 바라보는 방향 기준으로 앞쪽 칸이 청소되지 않았으면 -> 한 칸 전진
        3) 1번으로
*/

public class Main {

    static BufferedReader br;

    static int N; // (3 <= N <= 50)
    static int M; // (3 <= M <= 50)

    static int[] site; // 로봇 청소기 위치
    static int direction; // 로봇 청소기 방향

    static int[][] ROOM;

    static int[] dr = {-1, 0, 1, 0}; // 북, 동, 남, 서
    static int[] dc = {0, 1, 0, -1};

    static int count; // 청소하는 칸의 개수

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");

        site = new int[2];

        site[0] = Integer.parseInt(input[0]);
        site[1] = Integer.parseInt(input[1]);

        direction = Integer.parseInt(input[2]);

        ROOM = new int[N][M];

        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");

            for (int j = 0; j < M; j++) {
                ROOM[i][j] = Integer.parseInt(input[j]);
            }
        }

        // ---------------------------------- input ----------------------------------

        count = 0;

        clean();

        System.out.println(count);

    }

    static void clean() {

        // 현재 칸이 청소되지 않은 경우
        if (ROOM[site[0]][site[1]] == 0) {
            ROOM[site[0]][site[1]] = 2;
            count++;
        }

        // 주변 4칸 중 청소 안한 곳 O
        for (int k = direction; k > direction - 4; k--) {
            int d = (k + 7) % 4;

            int nr = site[0] + dr[d];
            int nc = site[1] + dc[d];

            if (ROOM[nr][nc] != 0) continue;

            // 방향 전환
            direction = d;

            // 1칸 전진
            site[0] = nr;
            site[1] = nc;

            // 처음으로
            clean();
        }

        // 주변 4칸 중 청소 안한 곳 X
        int reverseDirection = (direction + 6) % 4;

        int nr = site[0] + dr[reverseDirection];
        int nc = site[1] + dc[reverseDirection];

        // 뒤로 이동 불가능한 경우
        if (ROOM[nr][nc] == 1) return;

        // 뒤로 이동 가능한 경우
        site[0] = nr;
        site[1] = nc;

        clean();

    }

}