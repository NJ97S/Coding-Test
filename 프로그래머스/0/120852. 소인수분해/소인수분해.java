import java.util.*;

class Solution {
    public int[] solution(int n) {
        
        List<Integer> list = new ArrayList<>();

        int temp = n;
        for (int i = 2; i <= n; i++) {
            if (temp % i != 0) continue;
            
            list.add(i);
            
            while (temp % i == 0) {
                temp /= i;
            }
        }
        
        int[] answer = new int[list.size()];
        
        int idx = 0;
        for (int num: list) {
            answer[idx++] = num;
        }
        
        return answer;

    }
}