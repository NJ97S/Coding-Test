import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static BufferedReader br;
	
	static int answer;
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		
		answer = 0;
		
		String[] input = br.readLine().split(" ");
		
		for (int i = 0; i < 5; i++) {
			int num = Integer.parseInt(input[i]);
			
			answer += Math.pow(num, 2);
		}
		
		System.out.println(answer % 10);
		
	}
	
}