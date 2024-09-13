import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static BufferedReader br;
	static StringBuilder sb;
	
	static int N;
	static int M;
	
	static int[] selected;
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		selected = new int[M];
		perm(0, 0);
		
		System.out.println(sb);
		
	}
	
	static void perm(int idx, int visited) {
		
		// 기저 조건
		if (idx == M) {
			for (int elem: selected) sb.append(elem).append(" ");
			sb.append("\n");
			
			return;
		}
		
		// 재귀 부분
		for (int i = 0; i < N; i++) {
			
			selected[idx] = i + 1;
			perm(idx + 1, visited);
			
		}
		
	}
	
}