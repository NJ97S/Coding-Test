import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
[문제 링크]
- https://www.acmicpc.net/problem/9251
*/

/*
[문제 정리]
- 0.4 초 / 256 MB

- 두 문자열이 주어질 때, LCS 길이 구하기
*/

public class Main {

    static BufferedReader br;

    static char[] stringA;
    static char[] stringB;

    static int[][] dp;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        stringA = new char[input.length() + 1];
        for (int i = 0; i < input.length(); i++) {
            stringA[i + 1] = input.charAt(i);
        }

        input = br.readLine();

        stringB = new char[input.length() + 1];
        for (int i = 0; i < input.length(); i++) {
            stringB[i + 1] = input.charAt(i);
        }

        // ----------------------- input -----------------------

        dp = new int[stringB.length][stringA.length];

        for (int i = 1; i < stringB.length; i++) {
            for (int j = 1; j < stringA.length; j++) {

                if (stringB[i] == stringA[j]) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);

            }
        }

        System.out.println(dp[stringB.length - 1][stringA.length - 1]);

    }

}