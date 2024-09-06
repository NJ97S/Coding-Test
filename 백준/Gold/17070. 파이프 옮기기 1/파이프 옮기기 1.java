import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static BufferedReader br;
	
	static int N; // 격자판 크기 (3 <= N <= 16)
	
	static int[][] HOUSE;
	
	static int[] START_POINT = {1, 1}; // 시작 좌표
	static int[] END_POINT = {1, 2}; // 끝 좌표
	
	static int answer; // 파이프를 이동시키는 방법의 수
		
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		HOUSE = new int[N + 2][N + 2];
		
		for (int r = 0; r < N; r++) {
			String[] input = br.readLine().split(" ");
			
			for (int c = 0; c < N; c++) {
				HOUSE[r + 1][c + 1] = Integer.parseInt(input[c]);
			}
		}
		
		// ----------------------------- input -----------------------------
		
		answer = 0;
		
		movePipe(START_POINT[0], START_POINT[1], END_POINT[0], END_POINT[1]);
		
		System.out.println(answer);
		
	}

	static void movePipe(int startR, int startC, int endR, int endC) {
	
		if (endR == N && endC == N) {
			answer++;
			return;
		}
		
		if (endR <= 0 || endR > N || endC <= 0 || endC > N) return;
		
		// 파이프가 가로로 놓여진 경우 -> 오른쪽, 오른쪽 아래 대각선
		if (startR == endR) {
			if (HOUSE[endR][endC + 1] != 1) movePipe(endR, endC, endR, endC + 1);
			if (HOUSE[endR][endC + 1] != 1 && HOUSE[endR + 1][endC + 1] != 1 && HOUSE[endR + 1][endC] != 1) movePipe(endR, endC, endR + 1, endC + 1);
		}
		
		// 파이프가 아래로 놓여진 경우 -> 아래쪽, 오른쪽 아래 대각선
		if (startC == endC) {
			if (HOUSE[endR + 1][endC] != 1) movePipe(endR, endC, endR + 1, endC);
			if (HOUSE[endR][endC + 1] != 1 && HOUSE[endR + 1][endC + 1] != 1 && HOUSE[endR + 1][endC] != 1) movePipe(endR, endC, endR + 1, endC + 1);
		}
		
		// 파이프가 대각선으로 놓여진 경우 -> 오른쪽, 아래쪽, 오른쪽 아래 대각선
		if (startR != endR && startC != endC) {
			if (HOUSE[endR][endC + 1] != 1) movePipe(endR, endC, endR, endC + 1);
			if (HOUSE[endR + 1][endC] != 1) movePipe(endR, endC, endR + 1, endC);
			if (HOUSE[endR][endC + 1] != 1 && HOUSE[endR + 1][endC + 1] != 1 && HOUSE[endR + 1][endC] != 1) movePipe(endR, endC, endR + 1, endC + 1);
		}
		
	}
	
}