import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        String[] strArr = s.split(" ");
        
        int previous = -1;
        for (String str: strArr) {
            if (str.equals("Z")) {
                answer -= previous;
                continue;
            }
            
            int num = Integer.parseInt(str);
            
            answer += num;
            previous = num;
        }
        
        return answer;
    }
}