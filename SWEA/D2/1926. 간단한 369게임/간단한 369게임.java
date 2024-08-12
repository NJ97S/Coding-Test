import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		final int N = sc.nextInt();
		
		int[] count = new int[3]; // 일, 십, 백
		
		StringBuilder sb = new StringBuilder();
		
		for (int num = 1; num <= N; num++) {
			count[0]++;
			
			if (count[0] == 10) {
				count[0] = 0;
				count[1]++;
			}
			
			if (count[1] == 10) {
				count[1] = 0;
				count[2]++;
			}
			
			int numOfThree = getNumOfThree(count);
			
			if (numOfThree > 0) {
				for (int i = 0; i < numOfThree; i++) {
					sb.append("-");
				}
				
				sb.append(" ");
			} else {
				sb.append(num + " ");
			}
		}
		
		System.out.println(sb.toString());
		
		sc.close();
		
	}
	
	static int getNumOfThree(int[] count) {
		int numOfThree = 0;
		
		for (int elem: count) {
			if (elem == 3 || elem == 6 || elem == 9) numOfThree++;
		}
		
		return numOfThree;
	}
	
}