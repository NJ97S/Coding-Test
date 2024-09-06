import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	static BufferedReader br;
	static StringBuilder sb;
	
	static int N; // 명령의 수 (1 <= N <= 10,000)
	
	static Stack<Integer> stack;
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		stack = new Stack<>();
		
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			
			if (input[0].equals("push")) stack.push(Integer.parseInt(input[1]));
			else if (input[0].equals("pop")) sb.append(stack.isEmpty() ? -1 : stack.pop()).append("\n");
			else if (input[0].equals("size")) sb.append(stack.size()).append("\n");
			else if (input[0].equals("empty")) sb.append(stack.isEmpty() ? 1 : 0).append("\n");
			else if (input[0].equals("top")) sb.append(stack.isEmpty() ? -1 : stack.peek()).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
}