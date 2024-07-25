import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        
        char[] strArr = new char[my_string.length()];
        for (int i = 0; i < my_string.length(); i++) {
            strArr[i] = my_string.charAt(i);
        }
        
        int count = 0;
        for (char elem: strArr) {
            if ((int)elem - 48 < 10) count++;
        }
        
        int[] answer = new int[count];
        int idx = 0;
        for (char elem: strArr) {
            if ((int)elem - 48 < 10) answer[idx++] = (int)elem - 48;
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}