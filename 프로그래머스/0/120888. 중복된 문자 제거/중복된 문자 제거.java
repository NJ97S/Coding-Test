import java.util.*;

class Solution {
    public String solution(String my_string) {
        String answer = "";
        
        String[] strArr = my_string.split("");
        
        loop1: for (int i = 0; i < strArr.length; i++) {         
            for (int j = 0; j < i; j++) {
                if (strArr[i].equals(strArr[j])) continue loop1;
            }

            answer += strArr[i];
        }
        
        return answer;
    }
}