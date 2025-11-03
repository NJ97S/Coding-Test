import java.util.*;

class Solution {
    public String[] solution(String my_str, int n) {
        String[] answer = new String[(int) Math.ceil((double) my_str.length() / n)];
        
        String[] strArr = my_str.split("");
        
        int idx = 0;
        int count = 0;
        
        for (String str: strArr) {
            if (count == n) {
                idx++;
                count = 0;
            }
            
            if (count == 0) answer[idx] = "";
            
            answer[idx] += str;
            count++;
        }
        
        return answer;
    }
}