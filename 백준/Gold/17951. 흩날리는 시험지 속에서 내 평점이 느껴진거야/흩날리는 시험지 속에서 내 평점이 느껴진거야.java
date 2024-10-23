import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
[문제 링크]
- https://www.acmicpc.net/problem/17951
*/

/*
[문제 정리]
- 1 초 / 256 MB

- 시험지를 K개의 그룹으로 나눈 뒤, 각 그룹에서 맞은 문제 개수의 합 중 최솟값이 시험 점수

- 받을 수 있는 점수의 최댓값 출력
*/

/*
[풀이 방식]
- MIN: 인풋 중 가장 적은 점수  |  MAX: 인풋 총합

- 순서대로 값을 더하면서 MID 이상이 되면, 그룹 수 +1 해주고, 다음 그룹으로 넘어가기

- 그룹 수가 K보다 작다면, MID가 더 작아져야 한다.
- 그룹 수가 K보다 크다면, MID가 더 커져야 한다.
*/

public class Main {
	
	static BufferedReader br;
	
	static int N; // 시험지 개수 (1 <= K <= N <= 10^5)
	
	static int K; // 그룹 수
	
	static int[] EXAM; // 각 시험지에서 맞은 문제의 수
	
	static int MIN_SCORE; // 시험지 점수 중 최솟값
	static int TOTAL_SCORE; // 시험지 점수의 총합
	
	static int answer; // 받을 수 있는 최대 점수
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]);
		K = Integer.parseInt(input[1]);
		
		EXAM = new int[N];
		
		MIN_SCORE = 20;
		TOTAL_SCORE = 0;
		
		input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			int score = Integer.parseInt(input[i]);
			
			EXAM[i] = score;
			
			MIN_SCORE = Math.min(MIN_SCORE, score);
			TOTAL_SCORE += score;
		}
		
		// ------------------------- input -------------------------
		
		answer = 0;
		
		makeGroup(MIN_SCORE, TOTAL_SCORE);
		
		System.out.println(answer);
		
	}
	
	static void makeGroup(int left, int right) {
		
		// 기저 조건
		if (left > right) return;
		
		// 재귀 부분
		int mid = (left + right) / 2;
		
		int countOfGroup = 0; // 그룹의 수
		int sumOfScore = 0; // 한 그룹의 점수
		
		for (int score: EXAM) {
			sumOfScore += score;
			
			if (sumOfScore >= mid) {
				countOfGroup++;
				sumOfScore = 0;
			}
		}
		
		if (countOfGroup == K) answer = Math.max(answer, mid);
		
		if (countOfGroup >= K) makeGroup(mid + 1, right);
		else makeGroup(left, mid - 1);
		
	}
	
}