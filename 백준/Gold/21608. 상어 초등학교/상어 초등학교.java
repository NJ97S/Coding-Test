import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
[문제 링크]
https://www.acmicpc.net/problem/21608
*/

/*
[문제 정리]
- 1초 / 1024 MB

- N * N 크기의 교실, 학생 N^2 명
- 각 학생마다 좋아하는 학생 4명이 존재

- 자리 정하는 조건
  1. 비어있는 칸 중, 좋아하는 학생과 가장 많이 인접한 칸
  2. 인접한 칸이 가장 많이 비어있는 칸
  3. 행, 열의 번호가 가장 작은 칸

- 자리 배치 후, 학생의 만족도의 총 합 출력
  - 인접한 칸에 좋아하는 학생이 몇 명인지가 기준
  - 0명 -> 0
  - n명 -> 10 ^ (n - 1)
*/

/*
[풀이 방식]
- 각 학생에 대해,
- 좋아하는 학생이 가장 많이 인접한 칸 탐색 -> list에 저장
- list.size() > 1 이면, 각 칸에 대해 비어있는 인접한 칸 탐색
  - 인접한 칸이 몇 개인지 저장할 변수, 좌표를 저장할 변수 필요
  - 카운트 변수 < 현재 인접칸 개수 이면, 좌표 변경

- 만족도 계산
*/

public class Main {
	
	static BufferedReader br;
	
	static int N; // 교실 한 변의 길이 (3 <= N <= 20)
	
	static int[] NUM_OF_STUDENTS;
	static int[][] NUM_OF_LIKE_STUDENTS;
	
	static int[] dr = {-1, 0, 0, 1}; // 북, 서, 동, 남 (행, 열 작은 순서대로 탐색)
	static int[] dc = {0, -1, 1, 0};
	
	static int[][] classRoom; // 자리 배치
		
	static List<int[]> optimalSeats; // 좋아하는 학생이 가장 많이 인접한 칸
	
	static int[] finalSeat; // 학생을 앉힐 최종 자리
	
	static int satisfaction; // 만족도
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		NUM_OF_STUDENTS = new int[N * N];
		NUM_OF_LIKE_STUDENTS = new int[N * N][4];
		
		for (int i = 0; i < N * N; i++) {
			String[] input = br.readLine().split(" ");
			
			NUM_OF_STUDENTS[i] = Integer.parseInt(input[0]);
			
			for (int j = 0; j < 4; j++) {
				NUM_OF_LIKE_STUDENTS[i][j] = Integer.parseInt(input[j + 1]); 
			}
		}
		
		// ---------------------------- input ----------------------------
		
		// 학생 자리 배치
		classRoom = new int[N][N];
		
		// optimalSeats 배열의 첫 번째 좌표를 초기값으로 지정
		// 96 line 조건문 내에서, maxNumOfEmptySeat 값이 0일 경우를 고려하기 위함.
		classRoom[1][1] = NUM_OF_STUDENTS[0];
		
		for (int i = 1; i < N * N; i++) {
			
			optimalSeats = new LinkedList<>();
			
			getOptimalSeat(i);
			
			if (optimalSeats.size() > 1) {
				int maxNumOfEmptySeat = 0;
				finalSeat = new int[] {optimalSeats.get(0)[0], optimalSeats.get(0)[1]};
				
				for (int j = 0; j < optimalSeats.size(); j++) {
					int r = optimalSeats.get(j)[0];
					int c = optimalSeats.get(j)[1];
					
					int numOfEmptySeat = countNearEmptySeat(r, c);
					
					if (numOfEmptySeat > maxNumOfEmptySeat) {
						maxNumOfEmptySeat = numOfEmptySeat;
						finalSeat = new int[] {r, c};
					}
				}
			} else {
				int r = optimalSeats.get(0)[0];
				int c = optimalSeats.get(0)[1];
				
				finalSeat = new int[] {r, c};
			}
			
			classRoom[finalSeat[0]][finalSeat[1]] = NUM_OF_STUDENTS[i];
			
		}
		
		// 만족도 게산
		satisfaction = 0;
		
		getSatisfaction();
		
		// 정답 출력
		System.out.println(satisfaction);
		
	}
	
	// idx: NUM_OF_STUDENTS 배열의 인덱스
	static void getOptimalSeat(int idx) {
		
		int countOfLikeStudents = 0;
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				
				if (classRoom[r][c] != 0) continue;
				
				int count = 0;
				
				int nr = -1; // 반복문 종료 후에 사용해야 하는 좌표라, 반복문 밖에서 선언
				int nc = -1;
				
				for (int k = 0; k < 4; k++) {
					nr = r + dr[k];
					nc = c + dc[k];
					
					if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
					
					if (hasLikePerson(idx, nr, nc)) count++;
				}
				
				if (count > countOfLikeStudents) {
					countOfLikeStudents = count;
					optimalSeats.removeAll(optimalSeats);
					optimalSeats.add(new int[] {r, c});
				} else if (count == countOfLikeStudents) {
					optimalSeats.add(new int[] {r, c});
				}
				
			}
		}
		
	}
	
	static boolean hasLikePerson(int idx, int r, int c) {
		
		for (int num: NUM_OF_LIKE_STUDENTS[idx]) {
			if (num == classRoom[r][c]) return true;
		}
		
		return false;
		
	}
	
	static int countNearEmptySeat(int r, int c) {
		
		int count = 0;
		
		for (int k = 0; k < 4; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];
			
			if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
			
			if (classRoom[nr][nc] == 0) count++;
		}
		
		return count;
		
	}
	
	static void getSatisfaction () {
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				
				int countLikeStudents = 0;
				
				for (int k = 0; k < 4; k++) {
					int nr = r + dr[k];
					int nc = c + dc[k];
					
					if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
					
					int idx = getIndex(classRoom[r][c]);
					if (idx != -1 && hasLikePerson(idx, nr, nc)) countLikeStudents++;
				}
				
				if (countLikeStudents > 0) satisfaction += (int) Math.pow(10, countLikeStudents - 1);
				
			}
		}
		
	}
	
	static int getIndex(int num) {
		
		for (int i = 0; i < N * N; i++) {
			if (NUM_OF_STUDENTS[i] == num) return i;
		}
		
		return -1;
		
	}
	
}