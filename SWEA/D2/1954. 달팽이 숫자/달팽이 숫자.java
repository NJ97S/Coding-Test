import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);

    final int T = sc.nextInt();

    for (int testCase = 1; testCase <= T; testCase++) {
      final int N = sc.nextInt();

      int[][] answer = new int[N][N];

      answer[0][0] = 1;

      int r = 0;
      int c = 0;

      int[] dr = {0, 1, 0, -1};
      int[] dc = {1, 0, -1, 0};

      int num = 2;
      int directionCase = 0;

      while (num <= N * N) {
        int nr = r + dr[directionCase];
        int nc = c + dc[directionCase];

        if (nr < 0 || nr >= N || nc < 0 || nc >= N || answer[nr][nc] != 0) {
          directionCase = (directionCase + 1) % 4;
          continue;
        }

        answer[nr][nc] = num++;

        r = nr;
        c = nc;
      }

      System.out.println("#" + testCase);

      for (int row = 0; row < N; row++) {
        String line = "";

        for (int col = 0; col < N; col++) {
          line += answer[row][col] + " ";
        }

        System.out.println(line.trim());
      }
    }

    sc.close();

  }

}
