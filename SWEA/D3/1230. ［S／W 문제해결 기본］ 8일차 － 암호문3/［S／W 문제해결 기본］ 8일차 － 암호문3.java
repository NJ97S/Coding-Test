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
				String type = sc.next();
				
				if (type.equals("I") || type.equals("D")) {
					String site = sc.next();
					int siteNum = Integer.valueOf(site);
					
					String num = sc.next();
					int count = Integer.valueOf(num);
					
					if (type.equals("I")) {
						COMMAND[i] = new String[count + 3];
						
						COMMAND[i][0] = type;
						COMMAND[i][1] = site;
						COMMAND[i][2] = num;
						
						for (int j = 1; j <= count; j++) {
							COMMAND[i][2 + j] = sc.next();
						}
						
						for (int j = count + 2; j > 2; j--) {
							SENTENCE.add(siteNum, COMMAND[i][j]);					
						}
					}
					
					else if (type.equals("D")) {
						COMMAND[i] = new String[3];
						
						COMMAND[i][0] = type;
						COMMAND[i][1] = site;
						COMMAND[i][2] = num;
						
						for (int j = 0; j < count; j++) {
							SENTENCE.remove(siteNum);						
						}
					}
				}
				
				else {
					String num = sc.next();
					int count = Integer.valueOf(num);
					
					COMMAND[i] = new String[count + 2];
					
					COMMAND[i][0] = type;
					COMMAND[i][1] = num;
					
					for (int j = 1; j <= count; j++) {
						COMMAND[i][1 + j] = sc.next();
					}
					
					for (int j = 0; j < count; j++) {
						SENTENCE.add(SENTENCE.size() - 1, COMMAND[i][j]);					
					}
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
