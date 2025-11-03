import java.util.*;

class Solution {
    public int solution(String my_string) {
        String[] strArr = my_string.split(" ");
        
        int answer = Integer.parseInt(strArr[0]);
        
        String previous = "";
        for (int i = 1; i < strArr.length; i++) {
            if (strArr[i].equals("+") || strArr[i].equals("-")) {
                previous = strArr[i];
                continue;
            }
            
            switch(previous) {
                case "+":
                    answer += Integer.parseInt(strArr[i]);
                    break;
                case "-":
                    answer -= Integer.parseInt(strArr[i]);
                    break;
            }
        }
        
        return answer;
    }
}