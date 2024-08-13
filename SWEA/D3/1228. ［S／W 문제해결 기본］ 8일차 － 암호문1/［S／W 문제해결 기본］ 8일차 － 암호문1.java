import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for (int testCase = 1; testCase <= 10; testCase++) {
			// INPUT
			final int N = sc.nextInt();
			
			final List<String> SENTENCE = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				SENTENCE.add(sc.next());
			}
			
			final int M = sc.nextInt();
			
			final String[][] COMMAND = new String[M][];
			
			for (int i = 0; i < M; i++) {
				sc.next();
				String site = sc.next();
				int siteNum = Integer.valueOf(site);
				
				String num = sc.next();
				int count = Integer.valueOf(num);
				
				COMMAND[i] = new String[count + 3];
				
				COMMAND[i][0] = "I";
				COMMAND[i][1] = site;
				COMMAND[i][2] = num;
				
				for (int j = 1; j <= count; j++) {
					COMMAND[i][2 + j] = sc.next();
				}
				
				// 문제풀이
				for (int j = count + 2; j > 2; j--) {
					SENTENCE.add(siteNum, COMMAND[i][j]);					
				}
			}
			
			// 출력
			System.out.printf("#%d", testCase);
			
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 10; i++) {
				sb.append(" " + SENTENCE.get(i));
			}
			
			System.out.print(sb.toString() + "\n");
		}
		
		sc.close();

	}

}
