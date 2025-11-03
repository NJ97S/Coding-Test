import java.util.*;

class Solution {
    public int solution(String before, String after) {
        int answer = 1;
        
        String[] beforeArr = before.split("");
        String[] afterArr = after.split("");
        
        Arrays.sort(beforeArr);
        Arrays.sort(afterArr);
        
        for (int i = 0; i < beforeArr.length; i++) {
            if (!beforeArr[i].equals(afterArr[i])) return 0;
        }
        
        return answer;
    }
}