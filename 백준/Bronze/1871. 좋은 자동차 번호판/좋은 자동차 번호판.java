import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static BufferedReader br;
	static StringBuilder sb;
	
	static String[] INPUT;
	
	static int value1, value2;
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		final int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			INPUT = br.readLine().split("-");
			
			value1 = 0;
			
			for (int i = 0; i < 3; i++) {
				value1 += (INPUT[0].charAt(i) - 'A') * (int) Math.pow(26, 2 - i);
			}
			
			value2 = Integer.parseInt(INPUT[1]);
			
			sb.append(Math.abs(value1 - value2) <= 100 ? "nice" : "not nice").append("\n");
		}
		
		System.out.println(sb);
		
	}
	
}