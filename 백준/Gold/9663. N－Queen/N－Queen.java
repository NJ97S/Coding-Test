import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
[문제 링크]
- https://www.acmicpc.net/problem/9663
*/

/*
[문제 정리]
- 10초 / 128MB

- (N * N) 크기의 체스판 위에 퀸 N개를 서로 공격할 수 없도록 놓는 방법의 수
*/

public class Main {

    static BufferedReader br;

    static int N; // (1 <= N <= 15)

    static int[] board; // 각 행의 퀸 위치

    static int count; // 가능한 방법의 수

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        board = new int[N];
        count = 0;

        placeQueen(0);

        System.out.println(count);

    }

    static void placeQueen (int r) {

        // 기저 조건
        if (r >= N) {
            count++;
            return;
        }

        // 재귀 부분
        for (int c = 0; c < N; c++) {
            if (!isAbleAttack(r, c)) {
                board[r] = c;
                placeQueen(r + 1);
            }
        }

    }

    static boolean isAbleAttack (int r, int c) {

        for (int i = 0; i < r; i++) {
            if (board[i] == c) return true; // 같은 열

            if (Math.abs(r - i) == Math.abs(c - board[i])) return true; // 대각선
        }

        return false;

    }

}