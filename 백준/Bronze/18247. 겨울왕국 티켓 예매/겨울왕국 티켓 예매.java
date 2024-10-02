import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static BufferedReader br;
	static StringBuilder sb;
	
	static int X;
	static int Y;
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		final int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			String[] input = br.readLine().split(" ");
			
			X = Integer.parseInt(input[0]);
			Y = Integer.parseInt(input[1]);
			
			sb.append(X < 12 || Y < 4 ? -1 : 11 * Y + 4).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
}