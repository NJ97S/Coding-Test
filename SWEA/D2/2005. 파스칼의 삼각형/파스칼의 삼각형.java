import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	
	static BufferedReader br;
	
	static StringBuilder sb;
	
	static int N; // 삼각형의 크기
	
	static int[][] pascal; // 파스칼 삼각형
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		final int T = Integer.valueOf(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append("\n");
			
			N = Integer.valueOf(br.readLine());
			
			pascal = new int[N][N];
			
			pascal[0][0] = 1;
			sb.append(1).append("\n");
			
			for (int r = 1; r < N; r++) {
				pascal[r][0] = 1;
				pascal[r][r] = 1;
				
				sb.append(1).append(" ");
				
				for (int c = 1; c < r; c++) {
					pascal[r][c] = pascal[r - 1][c - 1] + pascal[r - 1][c];
					
					sb.append(pascal[r][c]).append(" ");
				}
				
				sb.append(1).append("\n");
			}
		}
		
		System.out.println(sb.toString());
		
	}
	
}