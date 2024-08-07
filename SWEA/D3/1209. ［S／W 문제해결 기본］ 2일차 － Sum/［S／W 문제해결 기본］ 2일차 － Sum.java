import java.util.Arrays;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);

    for (int testCase = 1; testCase <= 10; testCase++) {
      sc.nextInt();

      int[][] INPUT = new int[100][100]; // 100 * 100 배열 생성
      for (int i = 0; i < 100; i++) {
        for (int j = 0; j < 100; j++) {
          INPUT[i][j] = sc.nextInt();
        }
      }

      
      int answer = 0;

      // 가로줄 합 구하기
      for (int r = 0; r < 100; r++) {
        int rowSum = 0;

        for (int c = 0; c < 100; c++) {
          rowSum += INPUT[r][c];
        }

        answer = Math.max(answer, rowSum);
      }

      // 세로줄 합 구하기
      for (int c = 0; c < 100; c++) {
        int colSum = 0;

        for (int r = 0; r < 100; r++) {
          colSum += INPUT[r][c];
        }

        answer = Math.max(answer, colSum);
      }

      // 오른쪽 아래 대각선 합 구하기
      int rightSum = 0;

      for (int k = 0; k < 100; k++) {
        rightSum += INPUT[k][k];
      }

      answer = Math.max(answer, rightSum);

      // 왼쪽 아래 대각선 합 구하기
      int leftSum = 0;
      int colIdx = 99;

      for (int r = 0; r < 100; r++) {
        leftSum += INPUT[r][colIdx--];
      }

      answer = Math.max(answer, leftSum);

      System.out.printf("#%d %d\n", testCase, answer);
      // System.out.println("#" + testCase + " " + answer);
    }


    sc.close();

  }

}
