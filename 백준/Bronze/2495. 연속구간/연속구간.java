import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static BufferedReader br;
	static StringBuilder sb;
	
	static int[] NUMBERS;
	
	static int answer;
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		for (int testCase = 1; testCase <= 3; testCase++) {
			
			String[] input = br.readLine().split("");
			
			NUMBERS = new int[8];
			
			for (int i = 0; i < 8; i++) {
				NUMBERS[i] = Integer.parseInt(input[i]);
			}
			
			answer = 0;
			
			for (int i = 0; i < 8; i++) {
				int count = 1;
				
				for (int j = i + 1; j < 8; j++) {
					if (NUMBERS[i] != NUMBERS[j]) break;
					
					count++;
				}
				
				answer = Math.max(answer, count);
			}
			
			sb.append(answer).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
}