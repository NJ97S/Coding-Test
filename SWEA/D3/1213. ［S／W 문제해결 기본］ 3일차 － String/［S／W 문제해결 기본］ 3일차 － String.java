import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		// 입력
		Scanner sc = new Scanner(System.in);
		
		for (int testCase = 1; testCase <= 10; testCase++) {
			sc.nextInt();
			
			String SEARCH = sc.next();
			String INPUT = sc.next();
			
			int answer = 0;
			
			for (int i = 0; i < INPUT.length(); i++) {
				if (i <= INPUT.length() - SEARCH.length() && INPUT.charAt(i) == SEARCH.charAt(0)) {								
					boolean isSame = isSameTerm(INPUT, SEARCH, i);
					
					if (isSame) answer++;
				}
			}
			
			System.out.printf("#%d %d\n", testCase, answer);
		}
		
		sc.close();

	}
	
	static boolean isSameTerm(String input, String search, int i) {
		
		for (int k = 0; k < search.length(); k++) {
			if (input.charAt(i + k) != search.charAt(k)) return false;
		}
		
		return true;
		
	}
	
}