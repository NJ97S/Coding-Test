import java.util.Scanner;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        for (int testCase = 1; testCase <= 10; testCase++) {
            final int N = sc.nextInt();
            
            int[] input = new int[100];
            for (int i = 0; i < 100; i++) {
                input[i] = sc.nextInt();
            }
            
            for (int i = 0; i < N; i++) {
                Arrays.sort(input);
                
                if (input[99] - input[0] <= 1) {
                    break;
                }
                
                input[99]--;
                input[0]++;
            }
            
            Arrays.sort(input);
            
            int diffHeight = input[99] - input[0];
            
            System.out.printf("#%d %d\n", testCase, diffHeight);
        }
        
        sc.close();

    }

}
