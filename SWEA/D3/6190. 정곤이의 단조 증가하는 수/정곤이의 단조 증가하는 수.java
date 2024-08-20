import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	
	static BufferedReader br;
	static StringBuilder sb;
	
	static int N; // 양의 정수의 수
	static int[] NUMBERS; // 양의 정수 배열
	
	static int answer; // 단조 증가하는 수 중 최댓값
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		final int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");
			
			N = Integer.parseInt(br.readLine());
			
			String[] input = br.readLine().split(" ");
			
			NUMBERS = new int[N];
			for (int i = 0; i < N; i++) {
				NUMBERS[i] = Integer.parseInt(input[i]);
			}
			
			answer = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					int temp = NUMBERS[i] * NUMBERS[j];
					
					if (isIncreasing(temp)) answer = Math.max(answer, temp);
				}
			}
			
			sb.append(answer == 0 ? -1 : answer).append("\n");
		}
		
		System.out.println(sb.toString());
		
	}
	
	static boolean isIncreasing(int num) {
		if (num < 10) return true; // 한 자리 수라면 true 반환하고 종료
		
		int lastNum = num % 10;
		num /= 10;
		
		while (num > 0) {
			if (lastNum < num % 10) return false;
			
			lastNum = num % 10;
			num /= 10;
		}
		
		return true;
	}
	
}