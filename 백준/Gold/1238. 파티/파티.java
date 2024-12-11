import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
[문제 링크]
- https://www.acmicpc.net/problem/1238
*/

/*
[문제 정리]
- 1초 / 128MB

- N개의 숫자로 구분된 각 마을에 한 명의 학생이 살고 있다.
- N명의 학생이 X번 마을에 모여 파티를 벌일 예정
- 마을 사이에는 총 M개의 단방향 도로가 있고, i번째 길을 지나는데 Ti의 시간을 소비한다.

- 시작점과 끝점이 같은 도로는 없다.
- 시작점과 한 도시 A에서 다른 도시 B로 가는 도로의 개수는 최대 1개

- 오고 가는데 가장 오래 걸리는 학생의 소요 시간 출력
*/

/*
[풀이 방식]
- 유향 그래프 + 최단거리 + 가중치 양수 -> 다익스트라

- 각 마을에서 X로 가는 최단시간은 역방향 그래프 이용
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

    static int N; // 마을의 수 (1 <= N <= 1,000)
    static int M; // 도로의 수 (1 <= M <= 10,000)

    static int X; // 모일 마을의 번호

    static List<Node>[] adjListOut; // X에서 각 마을로 가는 경우
    static List<Node>[] adjListIn; // 각 마을에서 X로 가는 경우

    static int[] distOut; // X에서 각 마을로 가는 경우
    static int[] distIn; // 각 마을에서 X로 가는 경우

    static int maxTime; // 가장 오래 걸리는 학생의 소요시간

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        X = Integer.parseInt(input[2]);

        adjListOut = new ArrayList[N + 1];
        adjListIn = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            adjListOut[i] = new ArrayList<>();
            adjListIn[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");

            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int time = Integer.parseInt(input[2]);

            adjListOut[start].add(new Node(end, time));
            adjListIn[end].add(new Node(start, time));
        }

        distOut = new int[N + 1];
        Arrays.fill(distOut, Integer.MAX_VALUE);

        distIn = new int[N + 1];
        Arrays.fill(distIn, Integer.MAX_VALUE);

        dijkstra(X, adjListOut, distOut);
        dijkstra(X, adjListIn, distIn);

        maxTime = 0;

        for (int i = 1; i <= N; i++) {
            int time = distOut[i] + distIn[i];

            maxTime = Math.max(maxTime, time);
        }

        System.out.println(maxTime);

    }

    // start: 시작 정점의 번호
    static void dijkstra (int start, List<Node>[] adjList, int[] dist) {

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
        }

    }

}