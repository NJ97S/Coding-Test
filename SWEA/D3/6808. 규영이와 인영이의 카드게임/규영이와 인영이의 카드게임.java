import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	
	static BufferedReader br;
	static StringBuilder sb;
	
	static int TOTAL_CASE = 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2;
	
	static int[] CARD_GYU; // 규영이 카드 (순서 O)
	static int[] CARD_IN; // 인영이 카드 (순서 X)
	
	static int[] orderOfIn; // 인영이가 카드를 내는 순서
	
	static int numOfWin; // 규영이가 이기는 경우의 수
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		final int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase);
					
			boolean[] temp = new boolean[19]; // 어떤 카드를 규영이가 뽑아갔는지 기록하기 위한 임시 배열
			
			CARD_GYU = new int[9];
			String[] input = br.readLine().split(" ");
			for (int i = 0; i < 9; i++) {
				CARD_GYU[i] = Integer.parseInt(input[i]);
				temp[CARD_GYU[i]] = true;
			}
			
			CARD_IN = new int[9];
			int tempIdx = 0;	
			for (int i = 1; i < 19; i++) {
				if (!temp[i]) CARD_IN[tempIdx++] = i;
			}
			
			orderOfIn = new int[9];
			numOfWin = 0;
			
			getOrder(0, 0);
			
			sb.append(" ").append(numOfWin).append(" ").append(TOTAL_CASE - numOfWin).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	// 인영이가 카드를 내는 순서 (순열)
	static void getOrder(int idx, int visited) {
		
		if (idx >= 9) {
			if (isWinned()) numOfWin++;
			return;
		}
		
		for (int i = 0; i < 9; i++) {
			if ((visited & (1 << i)) != 0) continue;
			
			orderOfIn[idx] = CARD_IN[i];
			getOrder(idx + 1, visited | (1 << i));
		}
		
	}
	
	// 규영이가 이겼는 지 판단
	static boolean isWinned() {
		
		int scoreOfGyu = 0;
		int scoreOfIn = 0;
		
		for (int i = 0; i < 9; i++) {
			if (CARD_GYU[i] == orderOfIn[i]) continue;
			
			int sumOfCard = CARD_GYU[i] + orderOfIn[i];
			
			if (CARD_GYU[i] > orderOfIn[i]) scoreOfGyu += sumOfCard;
			else scoreOfIn += sumOfCard;
		}
		
		return scoreOfGyu > scoreOfIn ? true : false;
		
	}
}