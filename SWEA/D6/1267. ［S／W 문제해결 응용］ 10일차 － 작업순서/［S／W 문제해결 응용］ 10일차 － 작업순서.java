import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	
	static BufferedReader br;
	static StringBuilder sb;
	
	static int V; // 정점의 개수 
	static int E; // 간선의 개수
	
	static int[][] adjArr;
	static int[] degree;
	
	static Queue<Integer> queue;
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		for (int testCase = 1; testCase <= 10; testCase++) {
			sb.append("#").append(testCase);
			
			String[] input = br.readLine().split(" ");
			V = Integer.parseInt(input[0]);
			E = Integer.parseInt(input[1]);
			
			adjArr = new int[V + 1][V + 1];	
			degree = new int[V + 1];
			
			input = br.readLine().split(" ");
			
			for (int i = 0; i < input.length; i += 2) {
				int A = Integer.parseInt(input[i]);
				int B = Integer.parseInt(input[i + 1]);
				
				adjArr[A][B] = 1;
				degree[B]++;
			}
			
			queue = new LinkedList<>();
			
			for (int i = 1; i <= V; i++) {
				if (degree[i] == 0) queue.add(i);
			}
			
			while (!queue.isEmpty()) {	
				int curr = queue.poll();
				
				sb.append(" ").append(curr);
				
				for (int i = 1; i <= V; i++) {
					if (adjArr[curr][i] == 1) {
						degree[i]--;
						adjArr[curr][i] = 0;
						
						if (degree[i] == 0) queue.add(i);
					}
				}
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	}
	
}