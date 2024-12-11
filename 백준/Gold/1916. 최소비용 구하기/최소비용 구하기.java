import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
[문제 링크]
- https://www.acmicpc.net/problem/1916
*/

/*
[문제 정리]
- 0.5초 / 128MB

- N개의 도시, M개의 버스가 존재
- A번째 도시에서 B번째 도시까지 가는데 드는 최소 버스 비용
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

    static int N; // 도시의 개수 (1 <= N <= 1,000)
    static int M; // 버스의 개수 (1 <= M <= 100,000)

    static int START; // 출발 도시의 번호
    static int END; // 도착 도시의 번호

    static List<Node>[] adjList;

    static int[] dist;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        adjList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");

            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int cost = Integer.parseInt(input[2]);

            adjList[start].add(new Node(end, cost));
        }

        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        String[] input = br.readLine().split(" ");

        START = Integer.parseInt(input[0]);
        END = Integer.parseInt(input[1]);

        dijkstra();

        System.out.println(dist[END]);

    }

    static void dijkstra() {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N + 1];

        pq.add(new Node(START, 0));
        dist[START] = 0;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (curr.w > dist[curr.v]) continue;

            visited[curr.v] = true;

            for (Node node: adjList[curr.v]) {
                if (visited[node.v] || dist[curr.v] + node.w > dist[node.v]) continue;

                dist[node.v] = dist[curr.v] + node.w;
                pq.add(new Node(node.v, dist[node.v]));
            }

            if (curr.v == END) break;
        }

    }

}