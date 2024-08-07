import java.util.Scanner;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		for (int testCase = 1; testCase <= 10; testCase++) {
			sc.nextInt();
			
			final String INPUT = sc.next();
			
			int answer = evaluate(INPUT);
			
			System.out.printf("#%d %d\n", testCase, answer);
		}
		
		sc.close();
		
	}
	
	static String infixToPostfix(String infix) {
		String postfix = "";
		
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < infix.length(); i++) {
			char c = infix.charAt(i);
			
			if (c >= '0' && c <= '9') postfix += c;
			else if (stack.isEmpty()) stack.push(c);
			else {
				postfix += stack.pop();
				stack.push(c);
			}
		}
		
		while (!stack.isEmpty()) {
			postfix += stack.pop();
		}
		
		return postfix;
	}
	
	static int evalPostfix(String postfix) {
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < postfix.length(); i++) {
			char c = postfix.charAt(i);
			
			if (c >= '0' && c <= '9') stack.push(c - '0');
			
			else {
				int num2 = stack.pop();
				int num1 = stack.pop();
				
				stack.push(num1 + num2);
			}
		}
		
		return stack.pop();
	}
	
	static int evaluate(String expression) {
		String postfix = infixToPostfix(expression);
		
		return evalPostfix(postfix);
	}

}