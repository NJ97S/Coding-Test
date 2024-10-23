import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
[문제 링크]
- https://www.acmicpc.net/problem/1149
*/

/*
[문제 정리]
- 0.5 초 / 128 MB

- N개의 집을 R, G, B 중 하나로 색칠
- 인접한 집과 색이 달라야 한다.

- 모든 집을 칠하는 비용의 최솟값
*/

/*
[풀이 방식]
- N번 집을 C색으로 칠하는 최소 비용 = N번 집을 C로 칠하는 비용 + (N - 1)번 집을 C가 아닌 다른 색으로 칠한 것 중 최소 비용
*/

public class Main {
	
	static BufferedReader br;
	
	static int N; // 집의 수 (2 <= N <= 10^3)
	
	static int[][] PRICES; // 각 집을 R, G, B로 칠하는 비용
	
	static int[] minPrice; // 특정 집을 특정 색으로 칠하는 최소 비용
	
	static int answer;
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		PRICES = new int[N][3];
		
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			
			for (int j = 0; j < 3; j++) {
				PRICES[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		// ---------------------- input ----------------------
		
		answer = Integer.MAX_VALUE;
		
		minPrice = PRICES[0];
		
		for (int house = 1; house < N; house++) {
			int[] temp = new int[3];
			
			temp[0] = PRICES[house][0] + Math.min(minPrice[1], minPrice[2]);
			temp[1] = PRICES[house][1] + Math.min(minPrice[0], minPrice[2]);
			temp[2] = PRICES[house][2] + Math.min(minPrice[0], minPrice[1]);
			
			minPrice = temp;
		}
		
		for (int price: minPrice) {
			answer = Math.min(answer, price);
		}
		
		System.out.println(answer);
		
	}
	
}