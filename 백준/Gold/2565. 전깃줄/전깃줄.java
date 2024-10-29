import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/*
[문제 링크]
- https://www.acmicpc.net/problem/2565
*/

/*
[문제 설명]
- 1 초 / 128 MB

- 최소한의 전깃줄을 잘라, 전깃줄이 교차하지 않도록 만들기
- 같은 위치에 두 개 이상의 전깃줄이 연결되는 경우는 없다.
*/

/*
[풀이 방식]
- B 전봇대에 연결되는 위치를 내림차순으로 정렬
- 정렬된 상태로, A 전봇대에 연결되는 위치 중 LDS 구하기
*/

public class Main {

    static BufferedReader br;

    static int N; // 전깃줄 개수 (1 <= N <= 100)

    static int[][] LINES;

    static int[] LDS;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        LINES = new int[N][];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");

            LINES[i] = new int[] {Integer.parseInt(input[0]), Integer.parseInt(input[1])};
        }

        // ------------------------- input -------------------------

        Arrays.sort(LINES, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        LDS = new int[N];
        Arrays.fill(LDS, 1);

        LDS();

        System.out.println(N - getMaxCount());

    }

    static void LDS() {

        for (int i = 1; i < N; i++) {
            int maxValue = 0;

            for (int j = 0; j < i; j++) {
                if (LINES[j][0] > LINES[i][0]) maxValue = Math.max(maxValue, LDS[j]);
            }

            LDS[i] = maxValue + 1;
        }

    }

    static int getMaxCount() {

        int result = 0;

        for (int count: LDS) {
            result = Math.max(result, count);
        }

        return result;

    }

}