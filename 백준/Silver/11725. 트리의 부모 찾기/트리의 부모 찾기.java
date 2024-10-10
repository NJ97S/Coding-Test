import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
[문제 링크]
- https://www.acmicpc.net/problem/11725
*/

/*
[문제 정리]
- 1 초 / 256 MB

- 루트 없는 트리
- 트리의 루트를 1이라고 정했을 때, 각 노드의 부모 구하기
*/

/*
[풀이 방식]
- input을 다음과 같은 형태로 저장 -> {1: 6, 4}, {2: 4}, {3: 6, 5}, {4: 1, 2}, {5: 3}, {6: 1, 3}, {7: 4}

- 부모 노드 번호를 저장할 int 배열 생성
- 1번 노드부터 연결된 노드의 부모 노드 번호를 넣어주기
*/

public class Main {
	
	static BufferedReader br;
	static StringBuilder sb;
	
	static int N; // 노드의 개수 (2 <= N <= 100,000)
	
	static List<Integer>[] adjList; // 인접 리스트
	
	static int[] parentNode; // 각 노드의 부모 노드 번호
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		adjList = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N - 1; i++) {
			String[] input = br.readLine().split(" ");
			
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			
			adjList[a].add(b);
			adjList[b].add(a);
		}
		
		// ----------------------- input -----------------------
		
		parentNode = new int[N + 1];
		
		searchChild(1);
		
		for (int i = 2; i <= N; i++) {
			sb.append(parentNode[i]).append("\n");
		}
		
		System.out.println(sb.toString().trim());
		
	}
	
	static void searchChild(int pIdx) {
		
		for (int child: adjList[pIdx]) {
			if (parentNode[child] > 0) continue;
			
			parentNode[child] = pIdx;
			searchChild(child);
		}
		
	}
	
}