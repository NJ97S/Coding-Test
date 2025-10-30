import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
 #20182 골목 대장 호석
 
 - 1 ~ N 번까지의 교차로
 - 골목은 서로 다른 두 교차로를 양방향으로 이어줌
 - 임의의 두 교차로를 잇는 골목은 최대 1개
 
 - A -> B 까지 C원을 가지고 가야 함
 - 한 골목에서 내야 하는 최대 요금을 최소화 해야 함 -> 이걸 출력
 
 - 만약, 지금 가진 돈으로는 목표 지점에 갈 수 없다면 -1 출력
 */

public class Main {

    static BufferedReader br;
    
    static int N; // 교차로 개수 (1 ≤ N ≤ 100,000)
    static int M; // 골목 개수 (1 ≤ M ≤ 500,000)
    
    static int A; // 시작 교차로 번호
    static int B; // 도착 교차로 번호
    static int C; // 가진 돈 (1 ≤ C ≤ 2,000,000)
    
    static class Edge {
    	
    	int v; // 도착 정점
    	int w; // 비용
    	
    	Edge(int v, int w) {
    		this.v = v;
    		this.w = w;
    	}
    	
    }
    
    static class Node implements Comparable<Node> {
    	
    	int v; // 현재 정점
    	int sumOfCost; // 현재가지의 누적 비용
    	
    	public Node(int v, int sumOfCost) {
    		this.v = v;
    		this.sumOfCost = sumOfCost;
    	}

		@Override
		public int compareTo(Main.Node o) {
			return Integer.compare(this.sumOfCost, o.sumOfCost);
		}
    	
    }
    
    static List<Edge>[] adjList;
    
    static int[] dist;
    
    static int answer;
    
    public static void main(String[] args) throws IOException {
		
    	br = new BufferedReader(new InputStreamReader(System.in));
    	
    	String[] input = br.readLine().split(" ");
    	
    	N = Integer.parseInt(input[0]);
    	M = Integer.parseInt(input[1]);
    	A = Integer.parseInt(input[2]);
    	B = Integer.parseInt(input[3]);
    	C = Integer.parseInt(input[4]);
    	
    	adjList = new ArrayList[N + 1];
    	for (int i = 1; i <= N; i++) {
    		adjList[i] = new ArrayList<>();
    	}
    	
    	int maxCost = 0;
    	
    	for (int i = 0; i < M; i++) {
    		input = br.readLine().split(" ");
    		
    		int a = Integer.parseInt(input[0]);
    		int b = Integer.parseInt(input[1]);
    		int w = Integer.parseInt(input[2]);
    		
    		adjList[a].add(new Edge(b, w));
    		adjList[b].add(new Edge(a, w));
    		
    		maxCost = Math.max(maxCost, w);
    	}
    	
    	// -------------------------- input --------------------------
    	
    	answer = -1;
    	
    	int left = 0;
    	int right = maxCost;
    	
    	while (left <= right) {
    		int mid = (left + right) / 2;
    		
    		if (canReach(mid)) {
    			answer = mid;
    			right = mid - 1;
    		} else {
    			left = mid + 1;
    		}
    	}
    	
    	System.out.println(answer);
    	
	}
    
    static boolean canReach(int maxCost) {
    	
    	dist = new int[N + 1];
    	Arrays.fill(dist, Integer.MAX_VALUE);
    	
    	PriorityQueue<Node> pq = new PriorityQueue<>();
    	pq.add(new Node(A, 0));
    	dist[A] = 0;
    	
    	while (!pq.isEmpty()) {
    		Node curr = pq.poll();
    		
    		if (curr.sumOfCost > dist[curr.v] || curr.sumOfCost > C) continue;
    		
    		if (curr.v == B) return true;
    		
    		for (Edge next: adjList[curr.v]) {
    			if (next.w > maxCost) continue;
    			
    			int newCost = curr.sumOfCost + next.w;
    			
    			if (newCost < dist[next.v] && newCost <= C) {
    				dist[next.v] = newCost;
    				pq.add(new Node(next.v, newCost));
    			}
    		}
    	}
    	
    	return dist[B] <= C;
    	
    }

}