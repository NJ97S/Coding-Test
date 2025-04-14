import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int SIZE = A.length;
        
        int answer = 0;
        
        for (int i = 0; i < SIZE; i++) {
            answer += A[i] * B[SIZE - i - 1];
        }
        
        return answer;
        
    }
}