import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static BufferedReader br;
	
	static int N; // 체스판 세로 길이 (8 <= N <= 50)
	static int M; // 체스판 가로 길이 (8 <= M <= 50)
	
	static char[][] BOARD;
	
	static int answer; // 다시 칠해야 하는 정사각형 개수의 최솟값
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		BOARD = new char[N][M];
		for (int r = 0; r < N; r++) {
			input = br.readLine().split("");
			
			for (int c = 0; c < M; c++) {
				BOARD[r][c] = input[c].charAt(0);
			}
		}
		
		// -------------------------------- input --------------------------------
		
		answer = N * M;
		
		for (int r = 0; r <= N - 8; r++) {
			for (int c = 0; c <= M - 8; c++) {
				
				char firstColor = BOARD[r][c];
				
				changeColor(firstColor, r, c);
				
			}
		}
		
		System.out.println(answer);
		
	}

	static void changeColor(char firstColor, int row, int col) {
		
		// 첫 번째 색 고정
		int count = 0;
		
		for (int r = row; r < row + 8; r++) {
			for (int c = col; c < col + 8; c++) {
				
				if ((r - row) % 2 == 0) {
					if ((c - col) % 2 == 0 && BOARD[r][c] != firstColor) count++;
					else if ((c - col) % 2 != 0 && BOARD[r][c] == firstColor) count++;
				}
				
				else {
					if ((c - col) % 2 == 0 && BOARD[r][c] == firstColor) count++;
					else if ((c - col) % 2 != 0 && BOARD[r][c] != firstColor) count++;
				}
				
			}
		}
		
		answer = Math.min(answer, count);
		
		// 첫 번째 색 변경
		count = 0;
		
		for (int r = row; r < row + 8; r++) {
			for (int c = col; c < col + 8; c++) {
				
				if ((r - row) % 2 == 0) {
					if ((c - col) % 2 == 0 && BOARD[r][c] == firstColor) count++;
					else if ((c - col) % 2 != 0 && BOARD[r][c] != firstColor) count++;
				}
				
				else {
					if ((c - col) % 2 == 0 && BOARD[r][c] != firstColor) count++;
					else if ((c - col) % 2 != 0 && BOARD[r][c] == firstColor) count++;
				}
				
			}
		}
		
		answer = Math.min(answer, count);
		
	}
	
}