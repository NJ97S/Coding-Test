import java.util.Scanner;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		final int TC = sc.nextInt();
		
		for (int testCase = 1; testCase <= TC; testCase++) {
			final int K = sc.nextInt();
			
			 Stack<Integer> stack = new Stack<>();
			 
			 for (int i = 0; i < K; i++) {
				 int input = sc.nextInt();
				 
				 if (input == 0) {
					 stack.pop();
					 continue;
				 }
				 
				 stack.push(input);
			 }
			 
			 int answer = 0;
			 
			 for (int elem: stack) answer += elem;
			 
			 System.out.printf("#%d %d\n", testCase, answer);
		}
		
		sc.close();
		
	}

}