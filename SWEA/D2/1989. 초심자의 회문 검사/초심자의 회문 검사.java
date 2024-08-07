import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		// 입력
		Scanner sc = new Scanner(System.in);
		
		final int T = sc.nextInt();
		
		testLoop: for (int testCase = 1; testCase <= T; testCase++) {
			String input = sc.next();
			
			for (int i = 0; i < input.length() / 2; i++) {
				if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
					System.out.printf("#%d 0\n", testCase);
					continue testLoop;
				}
			}
			
			System.out.printf("#%d 1\n", testCase);
		}
		
		sc.close();

	}
	
}