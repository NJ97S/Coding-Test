import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	
	static BufferedReader br;
	static StringBuilder sb;
	
	static int N; // 방의 가로 길이
				  // 방의 세로 길이는 100으로 고정
	
	static int[] INPUT; // 쌓여있는 상자의 수
	
	static int answer; // 가장 큰 낙차
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		final int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");
			
			N = Integer.parseInt(br.readLine());
			
			INPUT = new int[N];
			String[] input = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				INPUT[i] = Integer.parseInt(input[i]);
			}
			
			answer = 0;
			
			for (int i = 0; i < N; i++) {
				int diffHeight = 0;
				
				for (int j = i + 1; j < N; j++) {
					if (INPUT[i] > INPUT[j]) diffHeight++;
				}
				
				answer = Math.max(answer, diffHeight);
			}
			
			sb.append(answer).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
}