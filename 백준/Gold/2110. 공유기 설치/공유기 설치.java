import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
[문제 링크]
- https://www.acmicpc.net/problem/2110
*/

/*
[문제 정리]
- 2 초 / 128 MB

- N개의 집에 C개의 공유기 설치
- 한 집에는 하나의 공유기만 설치 가능

- 가장 인접한 두 공유기 사이의 최대 거리
*/

/*
[풀이 방식]
- 집 좌표 범위가 10^9 => 이분 탐색

- input 받은 후, 배열 정렬 필요
- 0 ~ (MAX - MIN) 범위에서, 이분 탐색을 통해, 인접한 공유기 사이의 거리 결정

- prev 변수에 이전 집 좌표 저장
- (curr - prev)가 결정된 거리보다 같거나 크다면 -> 설치된 공유기 개수 + 1 && prev 재할당

- 설치된 공유기의 총 개수가 C보다 작다면 -> 공유기 사이 거리 낮추기
- 설치된 공유기의 총 개수가 C보다 같거나 크다면 -> 공유기 사이 거리 늘리기
*/

public class Main {

	static BufferedReader br;
	
	static int N; // 집 개수 (2 <= N <= 2 * 10^5)
	static int C; // 공유기 개수 (2 <= C <= N)
	
	static int[] HOUSES;
	
	static int maxDistance;
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		
		HOUSES = new int[N];
		
		for (int i = 0; i < N; i++) {
			HOUSES[i] = Integer.parseInt(br.readLine());
		}
		
		// ------------------ input ------------------
		
		Arrays.sort(HOUSES);
		
		maxDistance = 0;
		
		binarySearch(0, HOUSES[N - 1] - HOUSES[0]);
		
		System.out.println(maxDistance);

	}
	
	static void binarySearch(int left, int right) {
		
		// 기저 조건
		if (left > right) return;
		
		// 재귀 부분
		int mid = (left + right) / 2;
		
		int count = countWifi(mid);
		
		if (count == C) maxDistance = Math.max(maxDistance, mid);
		
		if (count >= C) binarySearch(mid + 1, right);
		else binarySearch(left, mid - 1);
		
	}
	
	static int countWifi(int dist) {
		
		int count = 1;
		
		int idxOfPrev = 0;
		
		for (int i = 1; i < N; i++) {
			
			if (HOUSES[i] - HOUSES[idxOfPrev] >= dist) {				
				count++;
				idxOfPrev = i;
			}
			
		}
		
		return Math.min(C, count);
		
	}

}