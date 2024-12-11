import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
[문제 링크]
- https://www.acmicpc.net/problem/1504
*/

/*
[문제 정리]
- 1초 / 256MB

- 무향 그래프에서 특정 두 정점을 반드시 지나는 최단 경로 구하기
- 가중치는 양수

- 한 번 이동했던 정점 또는 간선으로 다시 이동할 수 있다.

- 경로가 없다면 -1 출력
*/

/*
[풀이 방식]
- 가중치가 있는 그래프의 최단 경로 -> 다익스트라

- 반드시 지나야 하는 정점인 V1, V2가 있을 때, 아래 두 경우로 나누어 최단 경로 탐색
  - 1번 정점 -> V1  /  V1 -> V2  /  V2 -> 도착 정점
  - 1번 점점 -> V2  /  V2 -> V1  /  V1 -> 도착 정점
*/

public class Main {

    static BufferedReader br;

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

    static int N; // 정점의 개수 (2 <= N <= 800)
    static int E; // 간선의 개수 (0 <= E <= 200,000)

    static int V1; // 반드시 지나야 하는 정점 1
    static int V2; // 반드시 지나야 하는 정점 2

    static List<Node>[] adjList;

    static int[] dist;

    static long minDist1; // 최단 경로의 길이 (1 -> V1 -> V2 -> N)
    static long minDist2; // 최단 경로의 길이 (1 -> V2 -> V1 -> N)

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        E = Integer.parseInt(input[1]);

        adjList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            input = br.readLine().split(" ");

            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);

            adjList[a].add(new Node(b, c));
            adjList[b].add(new Node(a, c));
        }

        dist = new int[N + 1];

        input = br.readLine().split(" ");

        V1 = Integer.parseInt(input[0]);
        V2 = Integer.parseInt(input[1]);

        minDist1 = 0;
        minDist1 += dijkstra(1, V1);
        minDist1 += dijkstra(V1, V2);
        minDist1 += dijkstra(V2, N);

        minDist2 = 0;
        minDist2 += dijkstra(1, V2);
        minDist2 += dijkstra(V2, V1);
        minDist2 += dijkstra(V1, N);

        long answer = Math.min(minDist1, minDist2);

        System.out.println(answer >= Integer.MAX_VALUE ? -1 : answer);

    }

    static int dijkstra (int start, int end) {

        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N + 1];

        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (curr.w > dist[curr.v]) continue;

            visited[curr.v] = true;

            for (Node node: adjList[curr.v]) {
                if (visited[node.v] || dist[curr.v] + node.w > dist[node.v]) continue;

                dist[node.v] = dist[curr.v] + node.w;
                pq.add(new Node(node.v, dist[node.v]));
            }

            if (curr.v == end) break;
        }

        return dist[end];

    }

}