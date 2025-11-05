import java.util.*;

class Solution {
    public int solution(int[] sides) {
        
        int answer = 0;
        
        int shorter = Math.min(sides[0], sides[1]);
        int longer = Math.max(sides[0], sides[1]);
        
        return shorter * 2 - 1;
        
    }
}