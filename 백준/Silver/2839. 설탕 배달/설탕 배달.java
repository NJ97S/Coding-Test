/*
 - 사탕가게에 설탕 정확하게 N kg 배달
 - 설탕 봉지는 3kg, 5kg 있음
 
 - 최소 봉지 수 구하기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {	
	
	static BufferedReader br;
	
	static int N; // 배달해야 하는 총 무게 (3 <= N <= 5,000)
	
	static int count; // 배달한 봉지 수
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		count = 0;
		
		int five = N / 5;
		
		while (five >= 0) {
			
			if (delivery(N, five)) break;
			
			count = 0;
			five--;
			
		}
		
		System.out.print(count == 0 ? -1 : count);

	}
	
	static boolean delivery (int n, int five) {
		
		count += five;
		n -= five * 5;
		
		if (n % 3 != 0) return false;
		
		count +=  n / 3;
		
		return true;
		
	}

}