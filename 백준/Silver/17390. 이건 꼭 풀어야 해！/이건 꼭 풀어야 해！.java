import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
[문제 정리]
- 1초 / 512MB

- 길이 N짜리 수열 A 생성
- A를 비내림차순으로 정렬하여 수열 B 생성
*/

/*
[풀이 방법]
- 오름차순 정렬 후, 누적합 미리 계산
- 누적합 배열 맨 앞은 0 두기
- 1부터 3이면 -> 3 - 0
*/

public class Main {

    static BufferedReader br;
    static StringBuilder sb;

    static int N; // 수열의 길이 (1 <= N <= 300,000)
    static int Q; // 질문의 개수 (1 <= Q <= 300,000)

    static int[] A; // 수열
    static int[] sum; // 누적합

    static int L;
    static int R;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        // N, Q input 받기
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        Q = Integer.parseInt(input[1]);

        // 수열 A input 받은 후 오름차순 정렬
        A = new int[N];

        input = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(A);

        // 누적합 계산
        sum = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i - 1] + A[i - 1];
        }

        // 질문의 답 출력
        for (int i = 0; i < Q; i++) {
            input = br.readLine().split(" ");

            L = Integer.parseInt(input[0]);
            R = Integer.parseInt(input[1]);

            sb.append(sum[R] - sum[L - 1]).append("\n");
        }

        System.out.println(sb);

    }

}