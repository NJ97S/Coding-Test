import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		final int T = sc.nextInt();
		
		for (int testCase = 1; testCase <= T; testCase++) {
			final int N = sc.nextInt();
			final int M = sc.nextInt();
			
			char[][] INPUT = new char[N][M];
			for (int i = 0; i < N; i++) {
				String line = sc.next();
				for (int j = 0; j < M; j++) {
					INPUT[i][j] = line.charAt(j);
				}
			}
			
			// 최댓값으로 변수 초기화
			int answer = Integer.MAX_VALUE;
			
			// 하얀색과 파란색을 어디까지 색칠할건지 결정
			for (int whiteEnd = 0; whiteEnd < N - 2; whiteEnd++) {
				for (int blueEnd = whiteEnd + 1; blueEnd < N - 1; blueEnd++) {
					int changes = 0;
					
					for (int i = 0; i <= whiteEnd; i++) {
                        for (int j = 0; j < M; j++) {
                            if (INPUT[i][j] != 'W') {
                                changes++;
                            }
                        }
                    }

                    for (int i = whiteEnd + 1; i <= blueEnd; i++) {
                        for (int j = 0; j < M; j++) {
                            if (INPUT[i][j] != 'B') {
                                changes++;
                            }
                        }
                    }

                    for (int i = blueEnd + 1; i < N; i++) {
                        for (int j = 0; j < M; j++) {
                            if (INPUT[i][j] != 'R') {
                                changes++;
                            }
                        }
                    }
                    
                    answer = Math.min(answer, changes);
				}
			}
			
			System.out.printf("#%d %d\n", testCase, answer);
		}
		
		sc.close();
		
	}
	
}