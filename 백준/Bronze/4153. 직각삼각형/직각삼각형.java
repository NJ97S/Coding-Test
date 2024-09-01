import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static BufferedReader br;
	static StringBuilder sb;
	
	static int[] INPUT;
	
	static String answer;
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		while (true) {
			INPUT = new int[3];
			
			String[] input = br.readLine().split(" ");
			for (int i = 0; i < 3; i++) {
				INPUT[i] = Integer.parseInt(input[i]);
			}
			
			if (INPUT[0] == 0 && INPUT[1] == 0 && INPUT[2] == 0) break;
			
			Arrays.sort(INPUT);
			
			answer = INPUT[0] * INPUT[0] + INPUT[1] * INPUT[1] == INPUT[2] * INPUT[2] ? "right" : "wrong";
			
			sb.append(answer).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
}