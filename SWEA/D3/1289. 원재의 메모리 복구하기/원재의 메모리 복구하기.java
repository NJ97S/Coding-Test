import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	
	static BufferedReader br;
	static StringBuilder sb;
	
	static int[] originalNum; // 만들어야 하는 숫자
	static int[] currentNum; // 현재 숫자
	
	static int answer; // 최소 수정 횟수
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		final int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");
			
			String[] input = br.readLine().split("");
			
			originalNum = new int[input.length];
			for (int i = 0; i < input.length; i++) {
				originalNum[i] = Integer.parseInt(input[i]);
			}
			
			currentNum = new int[originalNum.length];
			
			answer = 0;
			
			for (int i = 0; i < originalNum.length; i++) {
				if (currentNum[i] != originalNum[i]) {
					changeNum(i);
					answer++;
				}
			}
			
			sb.append(answer).append("\n");
		}
		
		System.out.println(sb.toString());
		
	}
	
	static void changeNum(int startIdx) {
		 for (int i = startIdx; i < currentNum.length; i++) {
			 currentNum[i] = (currentNum[i] + 1) % 2;
		 }
	}
	
}