import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
	
	static BufferedReader br;
	static StringBuilder sb;
	
	static int N; // 정점의 개수 (1 <= N <= 1,000)
	
	static String[] value; // 정점의 값
	static int[][] linkedList; // 연결 리스트
	
	static Stack<Double> stack; // 숫자 저장해놓을 스택
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		for (int testCase = 1; testCase <= 10; testCase++) {
			sb.append("#").append(testCase).append(" ");
			
			N = Integer.parseInt(br.readLine());
			
			value = new String[N + 1];
			linkedList = new int[N + 1][2];
			
			for (int i = 1; i <= N; i++) {
				String[] input = br.readLine().split(" ");
				
				value[i] = input[1];
				
				if (input.length == 4) { // 자식 노드 있을 떄					
					linkedList[i][0] = Integer.parseInt(input[2]);
					linkedList[i][1] = Integer.parseInt(input[3]);
				}
			}
			
			stack = new Stack<>();
			
			postOrder(1);
			
			sb.append((int) Math.floor(stack.pop())).append("\n");
		}
		
		System.out.println(sb.toString());
		
	}
	
	static void postOrder(int root) {
		if (root < 1) return;
		
		if (linkedList[root][0] > 0 && linkedList[root][0] <= N) postOrder(linkedList[root][0]);
		if (linkedList[root][1] > 0 && linkedList[root][1] <= N) postOrder(linkedList[root][1]);
		
		calculate(value[root]);
	}
	
	static void calculate(String value) {
		if (!value.equals("+") && !value.equals("-") && !value.equals("*") && !value.equals("/")) {
			stack.push((double) Integer.parseInt(value));
			return;
		}
		
		double num2 = stack.pop();
		double num1 = stack.pop();
		
		switch(value) {
		case "+":
			stack.push(num1 + num2);
			break;
		case "-":
			stack.push(num1 - num2);
			break;
		case "*":
			stack.push(num1 * num2);
			break;
		case "/":
			stack.push(num1 / num2);
			break;
		}
	}
	
}