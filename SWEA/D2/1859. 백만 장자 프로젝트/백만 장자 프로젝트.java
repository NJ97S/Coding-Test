import java.util.Scanner;

/*
1. INPUT 배열 중 최댓값 찾기
2. 최댓값이 배열의 첫 번째 요소라면 => 바로 0 반환
3. 최댓값이 나오기 전까지 구매 => 최댓값일 때 모두 판매
*/

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		final int T = sc.nextInt();
		
		for (int testCase = 1; testCase <= T; testCase++) {
			final int N = sc.nextInt();
			
			final int[] INPUT = new int[N];
			
			int maxIdx = 0;
			
			for (int i = 0; i < N; i++) {
				INPUT[i] = sc.nextInt();
				
				// INPUT 받을 때 바로 최댓값 찾아서 인덱스 저장
				if (INPUT[i] > INPUT[maxIdx]) maxIdx = i;
			}
			
			if (maxIdx == 0) {
				System.out.printf("#%d %d\n", testCase, 0);
				continue;
			}
			
			int amount = 0;
			long profit = 0L;
			
			for (int day = 0; day < maxIdx; day++) {
				amount++;
				profit -= INPUT[day];
			}
			
			profit += amount * INPUT[maxIdx];
			amount = 0;
			
			while (maxIdx < N - 1) {
				int tempMaxIdx = getMaxIdx(maxIdx + 1, INPUT, N);
				
				for (int k = maxIdx + 1; k < tempMaxIdx; k++) {
					amount++;
					profit -= INPUT[k];
				}
				
				profit += amount * INPUT[tempMaxIdx];
				amount = 0;
				
				maxIdx = tempMaxIdx;
			}
			
			System.out.printf("#%d %d\n", testCase, profit);
		}
		
		sc.close();
		
	}
	
	static int getMaxIdx(int startDay, int[] INPUT, int N) {
		int maxIdx = startDay;
		
		for (int day = startDay; day < N; day++) {
			if (INPUT[day] > INPUT[maxIdx]) maxIdx = day;
		}
		
		return maxIdx;
	}
	
}