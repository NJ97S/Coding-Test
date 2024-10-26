import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
[문제 링크]
- https://www.acmicpc.net/problem/11660
*/

/*
[문제 정리]
- 1 초 / 256 MB

- 구간 합 구하기
*/

public class Main {

    static BufferedReader br;
    static StringBuilder sb;

    static int N; // 표의 크기 (1 <= N <= 1024)
    static int M; // 합으르 구해야 하는 횟수 (1 <= M <= 10^5)

    static int[][] PREFIX_SUM; // 누적합

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        PREFIX_SUM = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            input = br.readLine().split(" ");

            for (int j = 1; j <= N; j++) {
                PREFIX_SUM[i][j] = Integer.parseInt(input[j - 1]) + PREFIX_SUM[i][j - 1];
            }
        }

        for (int i = 1; i <= M; i++){
            int answer = 0;

            input = br.readLine().split(" ");

            int[] start = {Integer.parseInt(input[0]), Integer.parseInt(input[1])};
            int[] end = {Integer.parseInt(input[2]), Integer.parseInt(input[3])};

            for (int j = start[0]; j <= end[0]; j++) {
                answer += PREFIX_SUM[j][end[1]] - PREFIX_SUM[j][start[1] - 1];
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb.toString().trim());

    }

}