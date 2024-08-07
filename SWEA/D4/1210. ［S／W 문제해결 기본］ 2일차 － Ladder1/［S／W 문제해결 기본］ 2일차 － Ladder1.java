import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);

    for (int testCase = 1; testCase <= 10; testCase++) {
      sc.nextInt();
      
      int[][] INPUT = new int[100][100];
      for (int i = 0; i < 100; i++) {
    	  for (int j = 0; j < 100; j++) {
    		  INPUT[i][j] = sc.nextInt();
    	  }
      }
      
      int r = 99;
      int c = 0;
      for (int i = 0; i < 100; i++) {
    	  if (INPUT[99][i] == 2) {
    		  c = i;
    		  break;
    	  }
      }
      
      while (r > 0) {
    	  if (c > 0 && INPUT[r][c - 1] == 1) {
    		  while (c > 0 && INPUT[r][c - 1] == 1) c--;
    	  }
    	  else if (c < 99 && INPUT[r][c + 1] == 1) {
    		  while (c < 99 && INPUT[r][c + 1] == 1) c++;
    	  }
    	  
    	  r--;
      }
      
      System.out.printf("#%d %d\n", testCase, c);
    }

    sc.close();

  }

}
