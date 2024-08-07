import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);

    final int T = sc.nextInt();

    for (int testCase = 1; testCase <= T; testCase++) {
      final int N = sc.nextInt();

      int[] INPUT = new int[N];
      for (int i = 0; i < N; i++) {
        INPUT[i] = sc.nextInt();
      }

      // 카운팅 정렬
      int maxNum = INPUT[0];
      for (int i = 1; i < INPUT.length; i++) {
        maxNum = Math.max(maxNum, INPUT[i]);
      }

      int[] count = new int[maxNum + 1];
      for (int i = 0; i < INPUT.length; i++) {
        count[INPUT[i]]++;
      }

      for (int i = 1; i < count.length; i++) {
        count[i] += count[i - 1];
      }

      int[] sortedArr = new int[INPUT.length];
      for (int i = INPUT.length - 1; i >= 0; i--) {
        sortedArr[count[INPUT[i]] - 1] = INPUT[i];
        count[INPUT[i]]--;
      }

      // 출력
      System.out.print("#" + testCase + " ");

      String caseAnswer = "";
      for (int elem: sortedArr) caseAnswer += elem + " ";
      
      System.out.println(caseAnswer.trim());
    }

    sc.close();

  }

}
