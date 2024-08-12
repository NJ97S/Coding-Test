import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*

*/

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		final int T = sc.nextInt();
		
		for (int testCase = 1; testCase <= T; testCase++) {
			final int N = sc.nextInt();
			
			Set<Integer> count = new HashSet<>();
			
			for (int i = N; ; i += N) {				
				int[] numArr = numberToArray(i);
				
				for (int elem: numArr) {
					count.add(elem);
				}
				
				if (count.size() == 10) {
					System.out.printf("#%d %d\n", testCase, i);
					break;
				}
			}
		}
		
		sc.close();
		
	}
	
	static int[] numberToArray(int num) {
		int count = 0;
		
		int tempNum = num;
		while (tempNum > 0) {
			tempNum /= 10;
			count++;
		}
		
		int[] numArr = new int[count];
		
		for (int i = count - 1; i >= 0; i--) {
			numArr[i] = num % 10;
			num /= 10;
		}
		
		return numArr;
	}
	
}