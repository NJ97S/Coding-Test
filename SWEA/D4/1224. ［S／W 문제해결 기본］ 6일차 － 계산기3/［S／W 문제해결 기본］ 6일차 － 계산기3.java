import java.util.HashMap;
import java.util.Map;
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
	
	static Map<Character, Integer> priority = new HashMap<>();
	
	static {
		priority.put('+', 1);
		priority.put('-', 1);
		priority.put('*', 2);
		priority.put('/', 2);
	}
	
	static String prefixToPostfix(String prefix) {
		String postfix = "";
		
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < prefix.length(); i++) {
			char c = prefix.charAt(i);
			
			if (c >= '0' && c <= '9') postfix += c;
			else if (c == '(') stack.push(c);
			else if (c == ')') {
				while (stack.peek() != '(') postfix += stack.pop();
				
				stack.pop();
			}
			else {
				while (!stack.isEmpty() && stack.peek() != '(' && priority.get(stack.peek()) >= priority.get(c)) {
					postfix += stack.pop();
				}
				
				stack.push(c);
			}
		}
		
		while (!stack.isEmpty()) postfix += stack.pop();
		
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
				
				int result;
				
				if (c == '+') result = num1 + num2;
				else if (c == '-') result = num1 - num2;
				else if (c == '*') result = num1 * num2;
				else result = num1 / num2;
				
				stack.push(result);
			}
		}
		
		return stack.pop();
	}
	
	static int evaluate(String expression) {
		String postfix = prefixToPostfix(expression);
		
		return evalPostfix(postfix);
	}

}