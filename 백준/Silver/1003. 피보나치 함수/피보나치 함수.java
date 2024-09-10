import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static BufferedReader br;
	static StringBuilder sb;
	
	static int N;
	
	static int[][] count;
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		final int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine());
			
			count = new int[2][2];
			
			fibonacci(N);
			
			if (N == 0) {
				sb.append(1).append(" ").append(0).append("\n");
				continue;
			}
			
			sb.append(count[1][0]).append(" ").append(count[1][1]).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	static void fibonacci(int n) {
		
		for (int i = 0; i <= n; i++) {
			if (i == 0) {
				count[0][0]++;
				continue;
			}
			else if (i == 1) {
				count[1][1]++;
				continue;
			}
			
			int[] temp = new int[2];
			temp[0] = count[0][0] + count[1][0];
			temp[1] = count[1][0] + count[1][1];
			
			count[0][0] = count[1][0];
			count[0][1] = count[1][1];
			
			count[1][0] = temp[0];
			count[1][1] = temp[1];
		}
		
	}
	
}