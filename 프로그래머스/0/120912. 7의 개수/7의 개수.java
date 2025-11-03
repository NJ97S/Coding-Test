import java.util.*;

class Solution {    
    public int solution(int[] array) {
        int answer = 0;
        
        String numbers = "";
        for (int num: array) {
            numbers += num;
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            char c = numbers.charAt(i);
            
            if (c == '7') answer++;
        }
        
        return answer;
    }    
}