import java.util.*;

class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        
        int minDiff = Integer.MAX_VALUE;
        
        for (int num: array) {
            int diff = Math.abs(n - num);
            
            if (diff < minDiff) {
                answer = num;
                minDiff = diff;
            } else if (diff == minDiff) {
                answer = Math.min(answer, num);
            }
        }
        
        return answer;
    }
}