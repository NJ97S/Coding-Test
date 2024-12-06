import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
[문제 링크]
- https://www.acmicpc.net/problem/17626
*/

/*
[문제 정리]
- 0.5초 / 512MB

- 자연수를 만들 수 있는 제곱수의 최소 개수 출력
*/

public class Main {

    static BufferedReader br;

    static int N; // 1 <= N <= 50,000

    static int[] dp; // 특정 수를 만들기 위한 제곱수의 개수

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            dp[i] = i;

            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        System.out.println(dp[N]);

    }

}