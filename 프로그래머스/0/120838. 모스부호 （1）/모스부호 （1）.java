class Solution {
    public String solution(String letter) {
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        String[] input = letter.split(" ");
        
        String answer = "";
        
        for (String elem: input) {
            for (int i = 0; i < morse.length; i++) {
                if (elem.equals(morse[i])) {                    
                    answer += (char)((int)'a' + i);
                    break;
                }
            }
        }
        
        return answer;
    }
}