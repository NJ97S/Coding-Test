import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	
	static BufferedReader br;
	
	static int N; // 눌러야 하는 버튼의 개수
	
	static char[] BUTTON_TYPE; // 버튼 타입
	static int[] BUTTON_SITE; // 버튼 위치
	static int buttonIdx;
	
	static int siteB; // B 로봇의 현재 위치
	static int siteO; // O 로봇의 현재 위치
	
	static int nextB; // B 로봇이 다음에 움직일 위치
	static int nextO; // O 로봇이 다음에 움직일 위치
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		
		final int T = Integer.valueOf(br.readLine()); // 테스트 케이스의 수
		
		for (int testCase = 1; testCase <= T; testCase++) {			
			String[] input = br.readLine().split(" ");
			
			N = Integer.valueOf(input[0]);
			
			BUTTON_TYPE = new char[N];
			BUTTON_SITE = new int[N];
			
			int inputIdx = 1;
			
			for (int i = 0; i < N; i++) {
				BUTTON_TYPE[i] = input[inputIdx++].charAt(0);
				BUTTON_SITE[i] = Integer.valueOf(input[inputIdx++]);
			}
			
			buttonIdx = 0;
			
			// 출발점에 로봇 배치
			siteB = 1;
			siteO = 1;
			
			// 다음으로 누를 버튼
			nextB = getNextSite(buttonIdx, 'B');
			nextO = getNextSite(buttonIdx, 'O');
			
			int answer = 0;
			
			// BUTTON을 모두 누를 때까지 반복
			while (buttonIdx < N) {
				answer++;
				
				boolean isPushed = false;
				
				// BLUE
				if (nextB != -1) {
					if (siteB < nextB) siteB++;
					else if (siteB > nextB) siteB--;
					else if (BUTTON_TYPE[buttonIdx] == 'B') {
						isPushed = true;
						buttonIdx++;
						nextB = getNextSite(buttonIdx, 'B');
					}					
				}
				
				// ORANCE
				if (nextO != -1) {					
					if (siteO < nextO) siteO++;
					else if (siteO > nextO) siteO--;
					else if (BUTTON_TYPE[buttonIdx] == 'O' && !isPushed) {
						buttonIdx++;
						nextO = getNextSite(buttonIdx, 'O');
					}
				}
			}
			
			System.out.printf("#%d %d\n", testCase, answer);
		}
		
	}
	
	static int getNextSite(int startIdx, char robot) {
		for (int i = startIdx; i < N; i++) {
			if (BUTTON_TYPE[i] == robot) return BUTTON_SITE[i];
		}
		
		return -1;
	}
	
}