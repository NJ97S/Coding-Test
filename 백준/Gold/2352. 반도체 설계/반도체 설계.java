import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
[문제 정리]
- 2초 / 128MB

- n개의 포트와 n개의 포트를 꼬이지 않도록 연결할 수 있는 최대 개수
*/

/*
[풀이 방법]
- LIS (이분탐색)
*/

public class Main {

    static BufferedReader br;

    static int N; // 포트 개수 (1 <= N <= 40,000)

    static int[] ports;

    static int maxCount; // 최대 연결 개수

    static int[] lis;
    static int lastIdx;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");

        ports = new int[N];

        for (int i = 0; i < N; i++) {
            ports[i] = Integer.parseInt(input[i]);
        }

        // ------------------------- input -------------------------

        maxCount = 1;

        lis = new int[N];

        lis[0] = ports[0];
        lastIdx = 0;

        for (int i = 1; i < N; i++) {
            if (ports[i] > lis[lastIdx]) {
                maxCount++;
                lastIdx++;
                lis[lastIdx] = ports[i];
            } else {
                int result = binarySearch(0, lastIdx, ports[i]);
                lis[result] = ports[i];
            }
        }

        System.out.println(maxCount);

    }

    static int binarySearch(int leftIdx, int rightIdx, int target) {

        if (leftIdx > rightIdx) {
            return leftIdx;
        }

        int mid = (leftIdx + rightIdx) / 2;

        if (lis[mid] > target) return binarySearch(leftIdx, mid - 1, target);
        else return binarySearch(mid + 1, rightIdx, target);
    }

}