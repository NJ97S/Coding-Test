import java.util.*;

class Solution {
    public String solution(String my_string) {
        
        char[] strArr = new char[my_string.length()];
        for (int i = 0; i < my_string.length(); i++) {
            strArr[i] = my_string.charAt(i);
        }
        
        for (int i = 0; i < strArr.length; i++) {
            if ((int)strArr[i] <= 90) {
                int temp = (int)strArr[i] + 32;
                strArr[i] = (char)temp;
            }
        }
        
        Arrays.sort(strArr);
        
        String answer = "";
        for (char alphabet:strArr) answer += alphabet;
        
        return answer;
        
    }
}