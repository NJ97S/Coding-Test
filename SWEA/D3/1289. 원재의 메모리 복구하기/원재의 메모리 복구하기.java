import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		final int T = sc.nextInt();
		
		for (int testCase = 1; testCase <= T; testCase++) {
			final String INPUT = sc.next();
			
			String[] inputArr = INPUT.split("");
			
			String[] startNum = new String[INPUT.length()];
			for (int i = 0; i < startNum.length; i++) {
				startNum[i] = "0";
			}
			
			int answer = 0;
			
			for (int i = 0; i < startNum.length; i++) {				
				if (!inputArr[i].equals(startNum[i])) {
					answer++;
					
					if (startNum[i].equals("0")) {
						for (int j = i; j < startNum.length; j++) startNum[j] = "1";
					} else {
						for (int j = i; j < startNum.length; j++) startNum[j] = "0";
					}
				}
			}
			
			System.out.printf("#%d %d\n", testCase, answer);
		}
		
		sc.close();

	}

}
