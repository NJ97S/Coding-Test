import java.util.Scanner;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		caseLoop: for (int testCase = 1; testCase <= 10; testCase++) {
			int N = sc.nextInt();
			String input = sc.next();
			
			if (N % 2 != 0) {
				System.out.printf("#%d 0\n", testCase);
				continue;
			}
				
			String[] inputArr = input.split("");
			
			Stack<String> stack = new Stack<>();
			
			String[] OPEN = {"(", "{", "[", "<"};
			String[] CLOSED = {")", "}", "]", ">"};
			
			for (int i = 0; i < inputArr.length; i++) {
				if (hasOpenedElem(inputArr[i], OPEN)) {
					stack.push(inputArr[i]);
				}
				
				else if (!stack.isEmpty()) {
					int idxOfValue = getIdxOfValue(inputArr[i], CLOSED);
					
					String top = stack.pop();
					
					if (!OPEN[idxOfValue].equals(top)) {
						System.out.printf("#%d 0\n", testCase);
						continue caseLoop;
					}
				}
			}
			
			int answer = stack.isEmpty() ? 1 : 0;
			
			System.out.printf("#%d %d\n", testCase, answer);
		}
		
		sc.close();
		
	}
	
	static boolean hasOpenedElem(String k, String[] opened) {
		for (String elem: opened) {
			if (elem.equals(k)) return true;
		}
		
		return false;
	}
	
	static int getIdxOfValue(String k, String[] closed) {
		for (int i = 0; i < closed.length; i++) {
			if (closed[i].equals(k)) return i;
		}
		
		return -1;
	}

}