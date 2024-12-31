import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    static BufferedReader br;

    static int N; // 노드의 개수 (1 <= N <= 10,000)

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

    static List<Node>[] adjList;

    static int[] dist;

    static int radius;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        adjList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            String[] input = br.readLine().split(" ");

            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int w = Integer.parseInt(input[2]);

            adjList[a].add(new Node(b, w));
            adjList[b].add(new Node(a, w));
        }

        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dijkstra(N);

        int farNode = 1;
        for (int i = 1; i < N; i++) {
            if (dist[i] > dist[farNode]) farNode = i;
        }

        Arrays.fill(dist, Integer.MAX_VALUE);
        dijkstra(farNode);

        radius = 0;
        for (int i = 1; i <= N; i++) {
            radius = Math.max(radius, dist[i]);
        }

        System.out.println(radius);

    }

    static void dijkstra (int start) {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N + 1];

        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (curr.w > dist[curr.v]) continue;

            visited[curr.v] = true;

            for (Node node: adjList[curr.v]) {
                if (visited[node.v] | dist[curr.v] + node.w > dist[node.v]) continue;

                dist[node.v] = dist[curr.v] + node.w;
                pq.add(new Node(node.v, dist[node.v]));
            }
        }

    }

}