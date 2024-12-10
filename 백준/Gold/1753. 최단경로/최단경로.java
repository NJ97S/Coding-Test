import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
[문제 링크]
- https://www.acmicpc.net/problem/1753
*/

/*
[문제 정리]
- 1초 / 256MB

- 방향그래프가 주어질 때, 주어진 시작점에서 다른 모든 정점으로의 최단 경로 구하기
- 모든 간선의 가중치는 10 이하의 자연수
*/

/*
[풀이 방식]
- 가중치가 있는 그래프의 최단 거리 + 가중치 양수 -> 다익스트라
*/

public class Main {

    static BufferedReader br;
    static StringBuilder sb;

    static int V; // 정점의 개수 (1 <= V <= 20,000)
    static int E; // 간선의 개수 (1 <= E <= 300,000)

    static int K; // 시작 정점의 번호 (1 <= K <= V)

    static class Node implements Comparable<Node> {

        int v, w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.w, o.w);
        }
    }

    static List<Node>[] adjList;

    static int[] dist;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        String[] input = br.readLine().split(" ");

        V = Integer.parseInt(input[0]);
        E = Integer.parseInt(input[1]);

        K = Integer.parseInt(br.readLine());

        adjList = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            input = br.readLine().split(" ");

            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            int w = Integer.parseInt(input[2]);

            adjList[u].add(new Node(v, w));
        }

        // ----------------------------- input -----------------------------

        dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dijkstra(K);

        for (int i = 1; i <= V; i++) {
            if (dist[i] == Integer.MAX_VALUE) sb.append("INF").append("\n");
            else sb.append(dist[i]).append("\n");
        }

        System.out.println(sb);

    }

    // start: 시작 정점의 번호
    static void dijkstra(int start) {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[V + 1];

        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (curr.w > dist[curr.v]) continue;

            visited[curr.v] = true;

            for (Node node: adjList[curr.v]) {
                if (!visited[node.v] && dist[curr.v] + node.w < dist[node.v]) {
                    dist[node.v] = dist[curr.v] + node.w;
                    pq.add(new Node(node.v, dist[node.v]));
                }
            }
        }

    }

}