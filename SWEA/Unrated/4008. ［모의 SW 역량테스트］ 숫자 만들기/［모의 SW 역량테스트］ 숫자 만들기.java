import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	
	static BufferedReader br;
	static StringBuilder sb;
	
	static int N; // 숫자의 개수
	
	static int[] NUM_OF_OPERATOR; // (+, -, *, /)
	static char[] OPERATOR = {'+', '-', '*', '/'};
	
	static int[] NUMBERS;
	
	static char[] selected; // 선택된 연산자
	
	static int max;
	static int min;
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		final int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");
			
			N = Integer.parseInt(br.readLine());
			
			NUM_OF_OPERATOR = new int[4];
			
			String[] input = br.readLine().split(" ");
			for (int i = 0; i < 4; i++) {
				NUM_OF_OPERATOR[i] = Integer.parseInt(input[i]);
			}
			
			NUMBERS = new int[N];
			
			input = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				NUMBERS[i] = Integer.parseInt(input[i]);
			}
			
			// ----------------------- input -----------------------
			
			selected = new char[N - 1];
			
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			
			perm(0, NUM_OF_OPERATOR);
			
			sb.append(max - min).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	// idx: selected 배열 인덱스
	// arr: NUM_OF_OPERATOR 배열
	static void perm(int idx, int[] arr) {
		
		if (idx >= N - 1) {
			operate();
			
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			
			if (arr[i] == 0) continue;
			
			selected[idx] = OPERATOR[i];
			arr[i]--;
			
			perm(idx + 1, arr);
			
			arr[i]++;
		}
		
	}
	
	static void operate () {
		
		int idxOfNum = 0;
		int idxOfOperator = 0;
		
		int result = NUMBERS[idxOfNum++];
		
		while (idxOfOperator < N - 1) {
			
			char operator = selected[idxOfOperator++];
			
			switch (operator) {
			case '+':
				result += NUMBERS[idxOfNum++];
				break;
			case '-':
				result -= NUMBERS[idxOfNum++];
				break;
			case '*':
				result *= NUMBERS[idxOfNum++];
				break;
			case '/':
				result /= NUMBERS[idxOfNum++];
				break;
			}
			
		}
		
		max = Math.max(max, result);
		min = Math.min(min, result);
		
	}

}