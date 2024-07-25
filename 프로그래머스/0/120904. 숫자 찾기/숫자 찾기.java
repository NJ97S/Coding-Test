import java.util.*;

class Solution {
    public int solution(int num, int k) {       
        int count = 0;
        int temp = num;
        while (temp > 0) {
            temp /= 10;
            count++;
        }
        
        int[] numArr = new int[count];
        for (int i = count - 1; i >= 0; i--) {
            numArr[i] = num % 10;
            num /= 10;
        }
        
        for (int i = 0; i < numArr.length; i++) {
            if (numArr[i] == k) return i + 1;
        }
        
        return -1;
    }
}