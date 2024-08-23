import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	
	static BufferedReader br;
	static StringBuilder sb;
	
	static int N; // 양의 정수의 수 (1 <= N <= 1,000)
	static int[] INPUT; // (1 <= 각 숫자 <= 30,000)
	
	static int answer; // 단조 증가하는 수 중 최댓값
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		final int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");
			
			N = Integer.parseInt(br.readLine());
			
			INPUT = new int[N];
			
			String[] line = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				INPUT[i] = Integer.parseInt(line[i]);
			}
			
			answer = -1;
			
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					int multiply = INPUT[i] * INPUT[j];
					
					if (isIncreasing(multiply)) answer = Math.max(answer, multiply);
				}
			}
			
			sb.append(answer).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	static boolean isIncreasing(int num) {
		if (num < 10) return true;
		
		int lastElem = num % 10;
		num /= 10;
		
		while (num > 0) {
			if (lastElem < num % 10) return false;
			
			lastElem = num % 10;
			num /= 10;
		}
		
		return true;
	}
	
}