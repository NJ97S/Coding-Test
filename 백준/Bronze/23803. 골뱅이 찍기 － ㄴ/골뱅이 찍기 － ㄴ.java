import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static BufferedReader br;
	static StringBuilder sb;
	
	static int N;
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		for (int k = 0; k < 4; k++) {
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append("@");
				}
				sb.append("\n");
			}
			
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N * 5; j++) { 
				sb.append("@");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString().trim());
		
	}
	
}