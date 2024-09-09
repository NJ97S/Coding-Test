import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static BufferedReader br;
	
	static int N; // 수식의 길이 (1 <= N <= 19)
	
	static int[] NUMBERS;
	static char[] OPERATORS;
	
	static int answer; // 연산의 최댓값
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		String[] input = br.readLine().split("");
		
		NUMBERS = new int[N / 2 + 1];
		OPERATORS = new char[N / 2];
		
		int numIdx = 0;
		int opIdx = 0;
		
		for (int i = 0; i < input.length; i++) {
			if (i % 2 == 0) NUMBERS[numIdx++] = Integer.parseInt(input[i]);
			else OPERATORS[opIdx++] = input[i].charAt(0);
		}
		
		// -------------------------- input --------------------------
		
		answer = Integer.MIN_VALUE;
	
		addParenthesis(NUMBERS[0], 0);
		
		System.out.println(answer);
		
	}
	
	static void addParenthesis(int result, int opIdx) {
		
		if (opIdx >= OPERATORS.length) {			
			answer = Math.max(answer, result);
			return;
		}
		
		// 괄호 없을 때
		int res1 = operate(OPERATORS[opIdx], result, NUMBERS[opIdx + 1]);
		addParenthesis(res1, opIdx + 1);
		
		// 괄호 있을 때
		if (opIdx + 1 >= OPERATORS.length) return;
		
		int res2 = operate(OPERATORS[opIdx + 1], NUMBERS[opIdx + 1], NUMBERS[opIdx + 2]);
		addParenthesis(operate(OPERATORS[opIdx], result, res2), opIdx + 2);
		
	}
	
	static int operate(char operator, int num1, int num2) {
		int result = 0;
		
		switch (operator) {
		case '+':
			result = num1 + num2;
			break;
		case '-':
			result = num1 - num2;
			break;
		case '*':
			result = num1 * num2;
			break;
		}
		
		return result;
		
	}
	
}