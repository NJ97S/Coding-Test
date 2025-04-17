import java.util.*;
import java.io.*;

public class Solution {
    
    static BufferedReader br;
    static StringBuilder sb;
    
    static int T;

	public static void main(String[] args) throws Exception {
		
		br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        T = Integer.parseInt(br.readLine());
        
        for (int testCase = 1; testCase <= T; testCase++) {
            sb.append("#").append(testCase).append(" ");
            
        	int K = Integer.parseInt(br.readLine());
            
            Stack<Integer> stack = new Stack<>();
            
            for (int i = 0; i < K; i++) {
            	int number = Integer.parseInt(br.readLine());
                
                if (number == 0) stack.pop();
                else stack.push(number);
            }
            
            int sum = 0;
            
            for (int elem: stack) {
            	sum += elem;
            }
            
            sb.append(sum).append("\n");
        }
        
        System.out.println(sb);
		
	}

}