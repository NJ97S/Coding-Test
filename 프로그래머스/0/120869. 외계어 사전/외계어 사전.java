import java.util.*;

class Solution {
    public int solution(String[] spell, String[] dic) {
        
        int answer = 2;
        
        for (String word: dic) {
            String dupWord = word;
            
            int count = 0;
            for (String alphabet: spell) {
                String temp = dupWord.replace(alphabet, "");
                
                if (dupWord.length() != temp.length()) count++;
                
                if (dupWord.length() != temp.length() + 1) continue;
                
                dupWord = temp;
            }
            
            if (dupWord.equals("") && count == spell.length) return 1;
        }
        
        return answer;
        
    }
}