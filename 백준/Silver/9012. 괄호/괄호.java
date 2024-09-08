import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	static BufferedReader br;
	static StringBuilder sb;
	
	static Stack<Character> stack;
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		final int T = Integer.parseInt(br.readLine());
		
		caseLoop:
		for (int testCase = 1; testCase <= T; testCase++) {
			stack = new Stack<>();
			
			String input = br.readLine();
			
			for (int i = 0; i < input.length(); i++) {
				char elem = input.charAt(i);
				
				if (elem == '(') stack.push(elem);
				
				else if (stack.isEmpty()) {
					sb.append("NO").append("\n");
					continue caseLoop;
				}
				
				else stack.pop();
			}
			
			sb.append(stack.isEmpty() ? "YES" : "NO").append("\n");
		}
		
		System.out.println(sb);
		
	}
	
}