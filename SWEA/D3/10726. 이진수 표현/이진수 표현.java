import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	
	static BufferedReader br;
	static StringBuilder sb;
	
	static int N; // 마지막 N 비트
	static int M; // 10진수
	
	static String answer;

	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		final int T = Integer.valueOf(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");
			
			String[] input = br.readLine().split(" ");
			N = Integer.parseInt(input[0]);
			M = Integer.parseInt(input[1]);
			
			if (M == 0) {
				sb.append("OFF").append("\n");
				continue;
			}
			
			answer = "ON";
			
			int repeat = 0;
			while (M > 0 && repeat < N) {
				repeat++;
				
				if (M % 2 != 1) {
					answer = "OFF";
					break;
				}
				
				M /= 2;
				
				if (M == 0 && repeat < N) answer = "OFF";
			}
			
			sb.append(answer).append("\n");
		}
		
		System.out.println(sb);

	}

}