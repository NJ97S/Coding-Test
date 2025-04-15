import java.io.*;

class Solution {
    
    public String solution(String s) {
        
        StringBuilder sb = new StringBuilder();
        
        String formattedString = s.toLowerCase();
        
        boolean isStart = true;
        
        for (char c: formattedString.toCharArray()) {
            if (isStart && Character.isLetter(c)) sb.append(Character.toUpperCase(c));
            else sb.append(c);
            
            isStart = c == ' ';
        }
        
        return sb.toString();
        
    }
}