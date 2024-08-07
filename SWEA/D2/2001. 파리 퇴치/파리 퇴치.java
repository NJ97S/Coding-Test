import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);

    final int T = sc.nextInt();

    for (int testCase = 1; testCase <= T; testCase++) {
      final int N = sc.nextInt();
      final int M = sc.nextInt();

      int[][] INPUT = new int[N][N];
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++ ) {
          INPUT[i][j] = sc.nextInt();
        }
      }

      int answer = 0;

      for (int r = 0; r <= N - M; r++) {
        for (int c = 0; c <=  N- M; c++) {
          int tempSum = getSumOfFlies(INPUT, M, r, c);

          answer = Math.max(answer, tempSum);
        }
      }

      System.out.printf("#%d %d\n", testCase, answer);
    }

    sc.close();

  }

  static int getSumOfFlies(int[][] INPUT, int M, int r, int c) {
    int sum = 0;
    
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < M; j++) {
        sum += INPUT[r + i][c + j];
      }
    }

    return sum;
  }

}
