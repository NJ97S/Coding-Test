import java.util.*;

class Solution {
    public long solution(String numbers) {
        String[] NUMBERS = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        String temp = numbers;
        for (int i = 0; i < 10; i++) {
            temp = temp.replaceAll(NUMBERS[i], Integer.toString(i));
        }
        
        return Long.parseLong(temp);
    }
}