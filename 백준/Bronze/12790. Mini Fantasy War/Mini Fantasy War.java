import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static BufferedReader br;
	static StringBuilder sb;
	
	static int[] BASIC;
	static int[] INCREASE;
	
	static int[] total;
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		final int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			
			BASIC = new int[4];
			INCREASE = new int[4];
			
			String[] input = br.readLine().split(" ");
			
			for (int i = 0; i < 4; i++) {
				BASIC[i] = Integer.parseInt(input[i]);
			}
			
			for (int i = 4; i < 8; i++) {
				INCREASE[i % 4] = Integer.parseInt(input[i]);
			}
			
			// --------------------- input ---------------------
			
			total = new int[4];
			
			for (int i = 0; i < 4; i++) {
				int sum = BASIC[i] + INCREASE[i];
				
				if (i == 0 || i == 1) total[i] = sum > 1 ? sum : 1;
				else if (i == 2) total[i] = sum > 0 ? sum : 0;
				else total[i] = sum;
			}
			
			int answer = total[0] + 5 * total[1] + 2 * total[2] + 2 * total[3];
			
			sb.append(answer).append("\n");
			
		}
		
		System.out.println(sb);
		
	}
	
}