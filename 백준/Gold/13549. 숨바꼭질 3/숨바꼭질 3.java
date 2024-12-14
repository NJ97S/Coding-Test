import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

/*
[문제 링크]
- https://www.acmicpc.net/problem/13549
*/

/*
[문제 정리]
- 2초 / 512MB

- 수빈이는 현재 N에 있고, 동생은 K에 있다.
- 수빈이는 걷거나 순간이동을 할 수 있다.

- 수빈이의 현재 위치가 X일 때,
- 걷는다면, 1초 후 (X - 1) 또는 (X + 1)로 이동
- 순간이동 한다면, 0초 후 (X * 2)로 이동

- 수빈이가 동생을 찾는 가장 빠른 시간 출력
*/

public class Main {

    static BufferedReader br;

    static class Node implements Comparable<Node> {

        int v, w;

        public Node (int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.w, o.w);
        }

    }

    static int N; // 수빈 위치 (0 <= N <= 100,000)
    static int K; // 동생 위치 (0 <= K <= 100,000)

    static int MAX = 100000;

    static int[] dist;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        dist = new int[MAX + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dijkstra();

        System.out.println(dist[K]);

    }

    static void dijkstra () {

        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(N, 0));
        dist[N] = 0;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (curr.w > dist[curr.v]) continue;

            if (curr.v * 2 <= MAX && curr.w < dist[curr.v * 2]) {
                dist[curr.v * 2] = curr.w;
                pq.add(new Node(curr.v * 2, curr.w));
            }

            if (curr.v + 1 <= MAX && curr.w + 1 < dist[curr.v + 1]) {
                dist[curr.v + 1] = curr.w + 1;
                pq.add(new Node(curr.v + 1, curr.w + 1));
            }

            if (curr.v - 1 >= 0 && curr.w + 1 < dist[curr.v - 1]) {
                dist[curr.v - 1] = curr.w + 1;
                pq.add(new Node(curr.v - 1, curr.w + 1));
            }
        }

    }

}