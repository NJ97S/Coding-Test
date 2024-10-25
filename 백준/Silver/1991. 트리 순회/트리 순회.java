import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static BufferedReader br;
	
	static StringBuilder pre;
	static StringBuilder in;
	static StringBuilder post;
	
	static int N; // 노드 개수 (1 <= N <= 26)
	
	static char[][] CHILDS;
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		
		pre = new StringBuilder();
		in = new StringBuilder();
		post = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		CHILDS = new char[N][2];
		
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			
			int root = input[0].charAt(0) - 'A';

			for (int j = 1; j < 3; j++) {				
				CHILDS[root][j - 1] = input[j].charAt(0); 
			}
		}
		
		// ---------------------- input ----------------------
		
		getOrder(0);		
		
		System.out.println(pre);
		System.out.println(in);
		System.out.println(post);
		
	}
	
	static void getOrder(int root) {
		
		// 기저 조건
		if (root >= N) return;
		
		// 재귀 부분		
		pre.append((char)(root + 'A'));
		
		if (CHILDS[root][0] != '.') getOrder(CHILDS[root][0] - 'A');
		
		in.append((char)(root + 'A'));
		
		if (CHILDS[root][1] != '.') getOrder(CHILDS[root][1] - 'A');
		
		post.append((char)(root + 'A'));
		
	}
	
}