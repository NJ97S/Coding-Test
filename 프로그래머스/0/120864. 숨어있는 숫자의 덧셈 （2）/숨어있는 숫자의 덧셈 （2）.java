import java.util.*;

class Solution {
    public int solution(String my_string) {
        int answer = 0;
        
        String editedString = my_string.replaceAll("[^0-9]"," ");
        String[] arr = editedString.trim().split("\\s+");
        
        for (String str: arr) {
            if (str.equals("")) return answer;
            
            answer += Integer.parseInt(str);
        }
        
        return answer;
    }
}