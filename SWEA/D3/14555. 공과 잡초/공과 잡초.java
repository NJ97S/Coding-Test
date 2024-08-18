import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
- "(" => stack에 넣기
- "|" 또는 ")" => stack top이 "|" 또는 "(" 라면 => 공 갯수 +1
*/

public class Solution {
	
	static BufferedReader br;
	
	static Stack<String> stack;
	
	static int numOfBalls; // 초원에 놓았을 수 있는 공의 개수의 최솟값
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		
		final int T = Integer.valueOf(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			String[] INPUT = br.readLine().split("");
			
			stack = new Stack<>();
			
			numOfBalls = 0;
			
			for (String elem: INPUT) {
				if (elem.equals("(")) stack.push(elem);
				
				else if (elem.equals(")")) {
					if (!stack.isEmpty() && (stack.peek().equals("|") || stack.peek().equals("("))) {
						numOfBalls++;
						stack.pop();
					}
				}
				
				else if (elem.equals("|")) {
					if (!stack.isEmpty() && stack.peek().equals("(")) {
						numOfBalls++;
						stack.pop();
					}
					
					else stack.push(elem);
				}
			}
			
			System.out.printf("#%d %d\n", testCase, numOfBalls);
		}
	}
	
}