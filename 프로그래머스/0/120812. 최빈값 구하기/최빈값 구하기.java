import java.util.*;

class Solution {
    
    public int solution(int[] array) {
        
        int[] temp = new int[array.length + 1];
        
        for (int i = 0; i < array.length; i++) {
            temp[i] = array[i];
        }
        
        temp[temp.length - 1] = 1001;
        
        Arrays.sort(temp);
        
        int answer = temp[0];
        
        int maxCount = 0; // 최대 최빈값 개수
        int currCount = 1; // 현재 보고 있는 수의 개수
        
        for (int i = 1; i < temp.length; i++) {
            if (temp[i] == temp[i - 1]) {
                currCount++;
            } else {
                if (currCount > maxCount) {
                    answer = temp[i - 1];
                    maxCount = currCount;
                } else if (currCount == maxCount) {
                    answer = -1;
                }
                
                currCount = 1;
            }
        }
        
        return answer;
        
    }
    
}