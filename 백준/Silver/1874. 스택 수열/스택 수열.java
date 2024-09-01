import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	static BufferedReader br;
	static StringBuilder sb;
	
	static int N;
	
	static Stack<Integer> stack;
	
	static int num;
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		stack = new Stack<>();
		num = 1;
		
		for (int i = 0; i < N; i++) {
			int target = Integer.parseInt(br.readLine());
			
			if (stack.isEmpty()) {
				if (num <= N) {
					stack.push(num++);
					sb.append("+").append("\n");					
				} else {
					System.out.println("NO");
					return;
				}
			}
			
			if (stack.peek() == target) {
				stack.pop();
				
				sb.append("-").append("\n");
			}
			
			else if (stack.peek() < target) {					
				while (num <= target) {
					stack.push(num++);		
					sb.append("+").append("\n");					
				}
				
				stack.pop();
				sb.append("-").append("\n");
			} 
			
			else if (stack.peek() > target) {
				while (!stack.isEmpty() && stack.peek() >= target) {
					stack.pop();
					
					sb.append("-").append("\n");
				}
			}
		}
		
		System.out.println(sb);
		
	}
	
}